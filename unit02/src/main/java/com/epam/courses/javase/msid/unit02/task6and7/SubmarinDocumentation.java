package com.epam.courses.javase.msid.unit02.task6and7;

import java.lang.annotation.Documented;
import java.time.LocalDate;

/**
 * Created by msid on 27.02.17.
 */
@Documented
public @interface SubmarinDocumentation {
    /**
     * Date of creating this model.
     *
     * Date format should be DD:MM:YYYY.
     * @return
     */
    String  disignedDate();

    /**
     * Type and medicate information.
     * * @return
     */
    String typeProject();
}
