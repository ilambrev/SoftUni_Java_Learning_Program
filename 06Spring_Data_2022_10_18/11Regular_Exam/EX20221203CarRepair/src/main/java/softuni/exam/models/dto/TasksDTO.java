package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "tasks")
@XmlAccessorType(XmlAccessType.FIELD)
public class TasksDTO {

    @XmlElement(name = "task")
    private List<TaskCreateDTO> tasks;

    public TasksDTO() {
        this.tasks = new ArrayList<>();
    }

    public TasksDTO(List<TaskCreateDTO> tasks) {
        this();

        this.tasks = tasks;
    }

    public List<TaskCreateDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskCreateDTO> tasks) {
        this.tasks = tasks;
    }

}