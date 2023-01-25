package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.CustomerCreateDTO;
import exam.model.entity.Customer;
import exam.model.entity.Town;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
import exam.util.DataFromFile;
import exam.util.ValidationUtil;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static exam.constant.FilePaths.CUSTOMERS_JSON_PATH;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final TownRepository townRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final Gson gson;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, TownRepository townRepository, DataFromFile dataFromFile, ValidationUtil validationUtil, Gson gson) {
        this.customerRepository = customerRepository;
        this.townRepository = townRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return this.dataFromFile.read(CUSTOMERS_JSON_PATH);
    }

    @Override
    public String importCustomers() throws IOException {

        ModelMapper modelMapper = new ModelMapper();

        Converter<String, LocalDate> stringToDate = new AbstractConverter<>() {
            @Override
            protected LocalDate convert(String source) {
                return LocalDate.parse(source, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        };

        PropertyMap<CustomerCreateDTO, Customer> customerMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                using(stringToDate).map(source.getRegisteredOn(), destination.getRegisteredOn());
            }
        };

        modelMapper.addMappings(customerMap);

        StringBuilder messages = new StringBuilder();

        CustomerCreateDTO[] customerDTOs = this.gson.fromJson(readCustomersFileContent(), CustomerCreateDTO[].class);

        for (CustomerCreateDTO customerDTO : customerDTOs) {

            if (this.validationUtil.isValid(customerDTO)) {

                Optional<Customer> optionalCustomer = this.customerRepository.findByEmail(customerDTO.getEmail());

                Optional<Town> optionalTown = this.townRepository.findByName(customerDTO.getTown().getName());

                if (optionalCustomer.isEmpty() && optionalTown.isPresent()) {

                    Town town = optionalTown.get();
                    Customer customer = modelMapper.map(customerDTO, Customer.class);
                    customer.setTown(town);

                    messages.append(String.format("Successfully imported Customer %s %s - %s",
                            customer.getFirstName(), customer.getLastName(), customer.getEmail()))
                            .append(System.lineSeparator());

                    this.customerRepository.saveAndFlush(customer);

                } else {
                    messages.append("Invalid Customer").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid Customer").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

}