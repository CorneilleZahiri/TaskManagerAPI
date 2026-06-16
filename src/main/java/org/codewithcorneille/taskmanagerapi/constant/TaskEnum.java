package org.codewithcorneille.taskmanagerapi.constant;

import java.util.Arrays;
import java.util.List;

public enum TaskEnum {
    TODO,
    IN_PROGRESS,
    DONE;

    public static List<String> taskEnumList() {
        return Arrays.stream(TaskEnum.values()).map(Enum::name).toList();
    }
}
