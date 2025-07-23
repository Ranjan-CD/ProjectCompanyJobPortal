package com.project.JobApp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
//@XmlRootElement(name = "jobPost")
@Entity
public class JobPost {

   // @XmlElement
    @Id
    private int postId;

   // @XmlElement
    private String postProfile;

   // @XmlElement
    private String postDesc;

   // @XmlElement
    private int reqExperience;

    //@XmlElementWrapper(name = "postTechStack")       // for wrapping list
   // @XmlElement(name = "postTechStack")              // for each item
    private List<String> postTechStack;
}
