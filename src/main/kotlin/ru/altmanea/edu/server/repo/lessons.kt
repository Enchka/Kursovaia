package ru.altmanea.edu.server.repo

import ru.altmanea.edu.server.model.Day
import ru.altmanea.edu.server.model.Lesson
import ru.altmanea.edu.server.model.Teacher
import ru.altmanea.edu.server.model.TimeTable

//val lessonsRepo = ListRepo<Lesson>()
//val timetableRepo = ListRepo<TimeTable>()
val teacherRepo = ListRepo<Teacher>()
//val dayRepo = ListRepo<Day>()
public val mapLessons: MutableMap<String, String> = mutableMapOf()
//вносим расписание по парам
val mondayUp = listOf(
    Lesson("лаб.", "21м", "информ.технологии", "1-322"), Lesson(), Lesson(), Lesson(), Lesson(),
    )
val mondayDown = listOf(
    Lesson("лаб.", "21и", "информ.технологии", "1-322"), Lesson("кср.", "21и", "информ.технологи", "1-329"), Lesson("кср.", "21м", "информ.технологи", "1-326"), Lesson(), Lesson()
)
val tuesdayUp = listOf(
    Lesson(), Lesson(), Lesson(), Lesson(), Lesson(),
)
val tuesdayDown = listOf(
    Lesson(), Lesson(), Lesson(), Lesson(), Lesson(),
)
val wednesdayUp = listOf(
    Lesson(), Lesson("лаб.", "21у", "инфо.сист.и техн", "3-315"), Lesson(), Lesson(), Lesson(),
)
val wednesdayDown = listOf(
    Lesson(), Lesson("лаб.", "21з", "информ.теологии", "1-322"), Lesson("лаб.", "21м", "информ.технологии", "1-112"), Lesson("лаб.", "21м", "информ.технологии", "1-325"), Lesson(),
)
val thursdayUp = listOf(
    Lesson(), Lesson("лаб.", "21и", "информ.теологии", "1-322"), Lesson(), Lesson(), Lesson(),
)
val thursdayDown = listOf(
    Lesson(), Lesson(), Lesson(), Lesson(), Lesson(),
)
val fridayUp = listOf(
    Lesson(), Lesson(), Lesson("лаб.", "21м", "информ.теологии", "1-467"), Lesson("лаб.", "21з", "информ.технологии", "1-467"), Lesson("лаб.", "21з", "информ.технологии", "1-325"),
)
val fridayDown = listOf(
    Lesson(), Lesson(), Lesson("пр.кср.", "21з", "информ.технологи", "1-406"), Lesson("лаб.", "21з", "информ.технологии", "1-325"), Lesson(),
)
val saturdayUp = listOf(
    Lesson(), Lesson(), Lesson(), Lesson(), Lesson(),
)
val saturdayDown = listOf(
    Lesson(), Lesson(), Lesson(), Lesson(), Lesson(),
)
//указываем день недели для пар
val MU = Day("Понедельник", mondayUp as MutableList<Lesson>)
val MD = Day("Понедельник", mondayDown as MutableList<Lesson>)
val TuU =Day("Вторник", tuesdayUp as MutableList<Lesson>)
val TuD =Day("Вторник", tuesdayDown as MutableList<Lesson>)
val WU =Day("Среда", wednesdayUp as MutableList<Lesson>)
val WD =Day("Среда", wednesdayDown as MutableList<Lesson>)
val ThU = Day("Четверг", thursdayUp as MutableList<Lesson>)
val ThD = Day("Четверг", thursdayDown as MutableList<Lesson>)
val FU = Day("Пятница", fridayUp as MutableList<Lesson>)
val FD = Day("Пятница", fridayDown as MutableList<Lesson>)
val SU = Day("Суббота", saturdayUp as MutableList<Lesson>)
val SD = Day("Суббота", saturdayDown as MutableList<Lesson>)
// Формируем четные и нечетные недели
val UpWeek = listOf(MU,TuU,WU,ThU,FU, SU)
val DownWeek = listOf(MD,TuD,WD,ThD,FD, SD)
//Формируем расписание
val Table = TimeTable(UpWeek as MutableList<Day>, DownWeek as MutableList<Day>)
//Расписание преподавателей
val teacherRepoTestData = listOf(
    Teacher("Профессор кафедры АиСУ Денисова Л.А.", Table),
    Teacher("Преподаватель кафедры АиСУ Головин Д.В.", Table)
)