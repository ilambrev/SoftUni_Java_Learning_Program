package bg.softuni.ex20230218reseller.services;

import bg.softuni.ex20230218reseller.models.dtos.CreateOfferDTO;
import bg.softuni.ex20230218reseller.models.dtos.OfferDTO;
import bg.softuni.ex20230218reseller.models.entities.ConditionEntity;
import bg.softuni.ex20230218reseller.models.entities.OfferEntity;
import bg.softuni.ex20230218reseller.models.entities.UserEntity;
import bg.softuni.ex20230218reseller.models.enums.ConditionNameEnum;
import bg.softuni.ex20230218reseller.repositories.OfferRepository;
import bg.softuni.ex20230218reseller.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final ConditionService conditionService;
    private final ModelMapper modelMapper;

    @Autowired
    public OfferService(OfferRepository offerRepository, UserRepository userRepository, UserService userService, ConditionService conditionService, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.conditionService = conditionService;
        this.modelMapper = modelMapper;
    }

    public boolean add(CreateOfferDTO createOfferDTO) {

        OfferEntity newOffer = this.modelMapper.map(createOfferDTO, OfferEntity.class);

        ConditionNameEnum categoryName = ConditionNameEnum.valueOf(createOfferDTO.getConditionName());

        ConditionEntity condition = this.conditionService.getConditionByName(categoryName);

        UserEntity user = this.userService.getLoggedUser();

        newOffer.setCondition(condition);
        newOffer.setUser(user);

        user.getOffers().add(newOffer);

        this.offerRepository.saveAndFlush(newOffer);
        this.userRepository.saveAndFlush(user);

        return true;
    }

    public void removeOffer(Long id) {

        this.offerRepository.deleteById(id);
    }

    public List<OfferDTO> getOtherUsersOffers() {

        Long loggedUserId = this.userService.getLoggedUser().getId();

        List<OfferEntity> otherUsersOffers = this.offerRepository.findAvailable(loggedUserId);

        return otherUsersOffers.stream().map(o -> this.modelMapper.map(o, OfferDTO.class)).toList();
    }

    public void buyOffer(Long id) {

        Optional<OfferEntity> offerOptional = this.offerRepository.findById(id);

        if (offerOptional.isPresent()) {

            OfferEntity offer = offerOptional.get();

            UserEntity user = this.userService.getLoggedUser();

            user.getBoughtOffers().add(offer);

            UserEntity seller = this.userService.getUserById(offer.getUser().getId());

            this.userRepository.saveAndFlush(user);

            Optional<OfferEntity> offerToRemove = seller.getOffers().stream().filter(o -> o.getId() == offer.getId().longValue()).findFirst();

            if (offerToRemove.isPresent()) {

                seller.getOffers().remove(offerToRemove.get());
                this.userRepository.saveAndFlush(seller);
            }

        }

    }

}