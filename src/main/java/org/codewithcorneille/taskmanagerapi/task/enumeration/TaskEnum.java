package org.codewithcorneille.taskmanagerapi.task.enumeration;

import java.util.Arrays;
import java.util.List;

public enum TaskEnum {
    A_FAIRE,
    EN_COURS,
    TERMINER;

    public static List<String> taskEnumList() {
        return Arrays.stream(TaskEnum.values()).map(Enum::name).toList();
    }
}
