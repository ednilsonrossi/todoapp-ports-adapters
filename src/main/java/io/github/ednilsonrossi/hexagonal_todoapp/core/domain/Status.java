package io.github.ednilsonrossi.hexagonal_todoapp.core.domain;

public enum Status {
    PENDING(1),         // Tarefa criada, mas não iniciada
    IN_PROGRESS(2),     // Tarefa em andamento
    COMPLETED(3),       // Tarefa finalizada
    CANCELED(99);       // Tarefa cancelada

    private final int order;

    Status(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public Status next() {
        if (this == PENDING) {
            return IN_PROGRESS;
        } else if (this == IN_PROGRESS) {
            return COMPLETED;
        } else {
            return this;
        }
    }

    public static Status fromCode(int code) {
        for (Status s : Status.values()) {
            if (s.getOrder() == code) {
                return s;
            }
        }
        throw new IllegalArgumentException("Code invalid: " + code);
    }
}
