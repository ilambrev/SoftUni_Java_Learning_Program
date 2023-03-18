package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TaskCreateDTO;
import softuni.exam.models.dto.TaskExportDTO;
import softuni.exam.models.dto.TasksDTO;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.models.entity.Part;
import softuni.exam.models.entity.Task;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.MechanicRepository;
import softuni.exam.repository.PartRepository;
import softuni.exam.repository.TaskRepository;
import softuni.exam.service.TaskService;
import softuni.exam.util.DataFromFile;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static softuni.exam.constants.FilePaths.TASKS_XML_PATH;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final CarRepository carRepository;
    private final MechanicRepository mechanicRepository;
    private final PartRepository partRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    private final ModelMapper modelMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, CarRepository carRepository, MechanicRepository mechanicRepository,
                           PartRepository partRepository, DataFromFile dataFromFile, ValidationUtil validationUtil,
                           XmlParser xmlParser, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.carRepository = carRepository;
        this.mechanicRepository = mechanicRepository;
        this.partRepository = partRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.taskRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return this.dataFromFile.read(TASKS_XML_PATH);
    }

    @Override
    public String importTasks() throws IOException, JAXBException {

        StringBuilder messages = new StringBuilder();

        TasksDTO taskDTOs = this.xmlParser.parseXML(TasksDTO.class, readTasksFileContent());

        for (TaskCreateDTO taskDTO : taskDTOs.getTasks()) {

            if (this.validationUtil.isValid(taskDTO)) {

                Optional<Mechanic> optionalMechanic = this.mechanicRepository.findByFirstName(taskDTO.getMechanic().getFirstName());
                Optional<Car> optionalCar = this.carRepository.findById(taskDTO.getCar().getId());
                Optional<Part> optionalPart = this.partRepository.findById(taskDTO.getPart().getId());

                if (optionalMechanic.isPresent() && optionalCar.isPresent() && optionalPart.isPresent()) {

                    Mechanic mechanic = optionalMechanic.get();
                    Car car = optionalCar.get();
                    Part part = optionalPart.get();
                    Task task = modelMapper.map(taskDTO, Task.class);
                    task.setMechanic(mechanic);
                    task.setCar(car);
                    task.setPart(part);
                    messages.append(String.format("Successfully imported task %.2f",
                            task.getPrice().doubleValue())).append(System.lineSeparator());

                    this.taskRepository.saveAndFlush(task);

                } else {
                    messages.append("Invalid task").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid task").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {

        ModelMapper modelMapper = new ModelMapper();

        StringBuilder tasksData = new StringBuilder();

        List<TaskExportDTO> taskDTOs = this.taskRepository.findByPrice()
                .stream().map(t -> modelMapper.map(t, TaskExportDTO.class)).toList();

        taskDTOs.forEach(t -> tasksData.append(t.toString()).append(System.lineSeparator()));

        return tasksData.toString().trim();
    }

}