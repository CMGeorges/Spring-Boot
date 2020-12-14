package org.camsley.dvdstore.web.form;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MovieForm {

    private Long id;

    @NotBlank(message = "Veuillez entrer un titre")
    @Size(max = 30)
    private String title;

    @NotBlank(message = "Veuillez choisir un genre")
    private String genre;

    @Size(max = 255,message = "Entrez une description de 255 caractères au plus")
    private String description;

    @NotBlank(message = "Veuillez entrer un prénom")
    @Size(max = 20)
    private String name;
    @Size(max = 20)
    private String firstName;


    public MovieForm() {
    }

    public MovieForm(String title, String genre) {
        this.genre=genre;
        this.title= title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
