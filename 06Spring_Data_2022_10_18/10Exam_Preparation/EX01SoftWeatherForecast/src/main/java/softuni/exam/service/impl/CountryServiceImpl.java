package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryCreateDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.DataFromFile;
import softuni.exam.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

import static softuni.exam.constants.FilePaths.COUNTRIES_JSON_PATH;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, DataFromFile dataFromFile, ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return this.dataFromFile.read(COUNTRIES_JSON_PATH);
    }

    @Override
    public String importCountries() throws IOException {

        StringBuilder messages = new StringBuilder();

        Set<ConstraintViolation<CountryCreateDTO>> violations;

        CountryCreateDTO[] countryDTOS = this.gson.fromJson(readCountriesFromFile(), CountryCreateDTO[].class);

        for (CountryCreateDTO countryDTO : countryDTOS) {
            violations = this.validationUtil.violation(countryDTO);

            if (violations.isEmpty()) {
                Optional<Country> countryOptional = this.countryRepository.findByCountryName(countryDTO.getCountryName());
                if(countryOptional.isPresent()) {
                    messages.append("Invalid country").append(System.lineSeparator());
                } else {
                    messages.append(String.format("Successfully imported country %s - %s", countryDTO.getCountryName(), countryDTO.getCurrency()))
                            .append(System.lineSeparator());
                    Country country = this.modelMapper.map(countryDTO, Country.class);
                    this.countryRepository.saveAndFlush(country);
                }
            } else {
                messages.append("Invalid country").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

}