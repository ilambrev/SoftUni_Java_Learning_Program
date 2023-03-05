package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplement;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;

        if ("ArtificialTurf".equals(fieldType)) {
            field = new ArtificialTurf(fieldName);
        } else if ("NaturalGrass".equals(fieldType)) {
            field = new NaturalGrass(fieldName);
        } else {
            throw new NullPointerException(INVALID_FIELD_TYPE);
        }

        this.fields.add(field);

        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplementToDeliver;

        if ("Powdered".equals(type)) {
            supplementToDeliver = new Powdered();
        } else if ("Liquid".equals(type)) {
            supplementToDeliver = new Liquid();
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }

        supplement.add(supplementToDeliver);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Field field = this.fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);

        Supplement supplementToField = this.supplement.findByType(supplementType);

        if (supplementToField == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        assert field != null;
        field.addSupplement(supplementToField);

        this.supplement.remove(supplementToField);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;

        if ("Men".equals(playerType)) {
            player = new Men(playerName, nationality, strength);
        } else if ("Women".equals(playerType)) {
            player = new Women(playerName, nationality, strength);
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        Field field = this.fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);

        assert field != null;
        String fieldType = field.getClass().getSimpleName();

        if (("Men".equals(playerType) && "NaturalGrass".equals(fieldType)) ||
                ("Women".equals(playerType) && "ArtificialTurf".equals(fieldType))) {
            field.addPlayer(player);
        } else {
            return String.format(FIELD_NOT_SUITABLE);
        }

        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = this.fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);

        int numberOfPlayersDragged = 0;

        assert field != null;
        for (Player p : field.getPlayers()) {
            p.stimulation();
            numberOfPlayersDragged++;
        }

        return String.format(PLAYER_DRAG, numberOfPlayersDragged);
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = this.fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);

        assert field != null;
        int fieldStrength = field.getPlayers().stream().mapToInt(Player::getStrength).sum();

        return String.format(STRENGTH_FIELD, fieldName, fieldStrength);
    }

    @Override
    public String getStatistics() {
        StringBuilder allFieldStats = new StringBuilder();

        for (Field field : this.fields) {
            allFieldStats.append(field.getInfo()).append(System.lineSeparator());
        }

        return allFieldStats.toString().trim();
    }
}