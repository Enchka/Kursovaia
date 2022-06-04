package ru.altmanea.edu.server.repo

import ru.altmanea.edu.server.model.Day
import ru.altmanea.edu.server.model.Lesson
import ru.altmanea.edu.server.model.Teacher
import ru.altmanea.edu.server.model.TimeTable

val teacherRepo = ListRepo<Teacher>()

public val mapLessons: MutableMap<String, String> = mutableMapOf()

val mondayUp1 = listOf(
    Lesson(), Lesson("лаб", "29з", "тестиропвыыв.програм.пр.", "1-467"), Lesson(), Lesson(), Lesson(),
)
val mondayDown1 = listOf(
    Lesson(), Lesson(), Lesson(), Lesson(), Lesson(),
)
val mondayUp2 = listOf(
    Lesson("лек", "28и", "проефвкт.среды", "1-326"),Lesson(),  Lesson(), Lesson(), Lesson(),
)
val mondayDown2 = listOf(
    Lesson(), Lesson(), Lesson(), Lesson(), Lesson(),
)
val tuesdayUp1 = listOf(
    Lesson("лаб", "29", "тестиров.праыВИграм.пр.", "1-467"), Lesson(), Lesson(), Lesson(), Lesson(),
)
val tuesdayDown1 = listOf(
    Lesson(), Lesson(), Lesson(), Lesson(), Lesson(),
)
val tuesdayUp2 = listOf(
    Lesson(), Lesson(), Lesson(), Lesson(), Lesson(),
)
val tuesdayDown2 = listOf(
    Lesson(), Lesson(), Lesson("лек", "28и", "прЫВИект.среды.авт.", "1-326"), Lesson("лаб", "28и", "проауаект.среды.авт.", "1-326"), Lesson(),
)
val wednesdayUp1 = listOf(
    Lesson(), Lesson(), Lesson(), Lesson(), Lesson(),
)
val wednesdayDown1 = listOf(
    Lesson(), Lesson( ), Lesson("лаб", "29з", "тестмвафЫВивавкеиров.програм.пр.", "1-467"), Lesson(), Lesson(),
)
val wednesdayUp2 = listOf(
    Lesson(), Lesson(), Lesson(), Lesson(), Lesson(),
)
val wednesdayDown2 = listOf(
    Lesson(), Lesson( ), Lesson("лаб", "29з", "тестмваифыыфвавкеиров.програм.пр.", "1-467"), Lesson(), Lesson(),
)
val thursdayUp1 = listOf(
    Lesson(), Lesson(), Lesson("кср", "29м", "текст.проФВМграм.пр.", "1-467"), Lesson(), Lesson(),
)
val thursdayDown1 = listOf(
    Lesson(), Lesson(), Lesson(), Lesson(), Lesson(),
)
val thursdayUp2 = listOf(
    Lesson(), Lesson(), Lesson("кср", "29м", "текст.проыфаграм.пр.", "1-467"), Lesson(), Lesson(),
)
val thursdayDown2 = listOf(
    Lesson(), Lesson(), Lesson(), Lesson(), Lesson(),
)
val fridayUp1 = listOf(
    Lesson("лаб.", "29м", "тестинг оф пыфарограммс", "1-467"), Lesson("лаб.", "29з", "тфыаестинг оф программс", "1-467"), Lesson("кср.", "29м", "тестинг оф прогрыфвпаммс", "1-467"), Lesson(), Lesson(),
)
val fridayDown1 = listOf(
    Lesson(), Lesson(), Lesson(), Lesson(), Lesson(),
)
val fridayUp2 = listOf(
    Lesson(), Lesson("лаб.", "28и", "проджеыфакт оф сред", "1-326"), Lesson(), Lesson(), Lesson(),
)
val fridayDown2 = listOf(
    Lesson(), Lesson(), Lesson(), Lesson("лаб.", "28и", "прфыаоджект оф сред", "1-326"), Lesson("лаб.", "28и", "проджект оф сред", "1-326"),
)
val saturdayUp1 = listOf(
    Lesson(), Lesson(), Lesson(), Lesson(), Lesson(),
)
val saturdayDown1 = listOf(
    Lesson("лаб.", "29м", "тестинг оф фыапрограммс", "1-467"), Lesson(), Lesson(), Lesson(), Lesson(),
)
val saturdayUp2 = listOf(
    Lesson(), Lesson(), Lesson(), Lesson(), Lesson(),
)
val saturdayDown2 = listOf(
    Lesson(), Lesson(), Lesson(), Lesson(), Lesson(),
)

val MU1 = Day("Понедельник", mondayUp1 as MutableList<Lesson>)
val MU2 = Day("Понедельник", mondayUp2 as MutableList<Lesson>)
val MD1 = Day("Понедельник", mondayDown1 as MutableList<Lesson>)
val MD2 = Day("Понедельник", mondayDown2 as MutableList<Lesson>)
val TuU1 =Day("Вторник", tuesdayUp1 as MutableList<Lesson>)
val TuU2 =Day("Вторник", tuesdayUp2 as MutableList<Lesson>)
val TuD1 =Day("Вторник", tuesdayDown1 as MutableList<Lesson>)
val TuD2 =Day("Вторник", tuesdayDown2 as MutableList<Lesson>)
val WU1 =Day("Среда", wednesdayUp1 as MutableList<Lesson>)
val WU2=Day("Среда", wednesdayUp2 as MutableList<Lesson>)
val WD1 =Day("Среда", wednesdayDown1 as MutableList<Lesson>)
val WD2 =Day("Среда", wednesdayDown2 as MutableList<Lesson>)
val ThU1 = Day("Четверг", thursdayUp1 as MutableList<Lesson>)
val ThU2 = Day("Четверг", thursdayUp2 as MutableList<Lesson>)
val ThD1 = Day("Четверг", thursdayDown1 as MutableList<Lesson>)
val ThD2 = Day("Четверг", thursdayDown2 as MutableList<Lesson>)
val FU1 = Day("Пятница", fridayUp1 as MutableList<Lesson>)
val FU2 = Day("Пятница", fridayUp2 as MutableList<Lesson>)
val FD1 = Day("Пятница", fridayDown1 as MutableList<Lesson>)
val FD2 = Day("Пятница", fridayDown2 as MutableList<Lesson>)
val SU1 = Day("Суббота", saturdayUp1 as MutableList<Lesson>)
val SU2 = Day("Суббота", saturdayUp2 as MutableList<Lesson>)
val SD1 = Day("Суббота", saturdayDown1 as MutableList<Lesson>)
val SD2 = Day("Суббота", saturdayDown2 as MutableList<Lesson>)

val UpWeek1 = listOf(MU1,TuU1,WU1,ThU1,FU1,SU1)
val DownWeek1 = listOf(MD1,TuD1,WD1,ThD1,FD1,SD1)
val UpWeek2 = listOf(MU2,TuU2,WU2,ThU2,FU2,SU2)
val DownWeek2 = listOf(MD2,TuD2,WD2,ThD2,FD2,SD2)

val Table1 = TimeTable(UpWeek1 as MutableList<Day>, DownWeek1 as MutableList<Day>)
val Table2 = TimeTable(UpWeek2 as MutableList<Day>, DownWeek2 as MutableList<Day>)

val teacherRepoTestData = listOf(
    Teacher("преп.ГоловинД.В.", Table1),
    Teacher("проф.ДенисоваЛ.А.", Table2)
)