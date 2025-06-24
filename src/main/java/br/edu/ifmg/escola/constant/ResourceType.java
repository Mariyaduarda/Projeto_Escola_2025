package br.edu.ifmg.escola.constant;

public enum ResourceType {

    LESSON_ONLY("Lição"),
    LESSON_TASK("Tarefa"),
    FORUM("Forum"),
    EXTERNAL_LIM("Link externo");

    private String description;

    private ResourceType(String description) {
        this.description = description;
    }
}
