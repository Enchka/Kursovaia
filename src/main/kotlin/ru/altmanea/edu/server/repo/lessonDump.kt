package ru.altmanea.edu.server.repo

import org.apache.poi.ss.usermodel.WorkbookFactory
import ru.altmanea.edu.server.model.Teacher
import org.apache.poi.xssf.usermodel.*
import ru.altmanea.edu.server.model.*
import ru.altmanea.edu.server.repo.ListRepo
import ru.altmanea.edu.server.rest.wayToFile
import java.io.FileInputStream

val teacherRepoDump = ListRepo<Teacher>()
val regexp = Regex(".*пр.кср..*|.*лаб..*|.*лек..*")
val fileInputsStream = FileInputStream(wayToFile)
var xlWbs = WorkbookFactory.create(fileInputsStream)
val tables = xlWbs.getSheetAt(0)
public fun ReturnsArrayOfTeachers(tables: XSSFSheet):
        MutableList<Teacher> { // возвращение массива преподавателей с их расписанием
    val ArOfTe: MutableList<Teacher> = mutableListOf()
    var currentTeacher: Teacher
    var i = 0 // счетчик преподавателей
    while (tables.getRow(32 * i + 6)?.getCell(1) != null) {
        currentTeacher = Teacher(tables.getRow(32 * i +
                6).getCell(1).toString(), readSchedules(i,tables)
        )
        ArOfTe.add(currentTeacher)
        i++
    }
    return ArOfTe
}
public fun readSchedules(idTeacher: Int, table: XSSFSheet):
        TimeTable// Ф-ия возвращает расписание для преподавателя
{
    val timeTable = TimeTable(mutableListOf(),
        mutableListOf())
    val start = 32 * idTeacher + 8 //Начальная строка
    var currentLesson: Lesson?// Содержит в себе текущую пару
    var Row = start //текущая строка
    var Cell = 1 // Текущая ячейка
    var ThisDayOne: Day
    var ThisDaySecond: Day
    val NextRow = Row + 19 // Следующая
    val PastCell = 6 // Последняя
    while (Cell <= PastCell)// будет заполняться пока текущая ячейка не будет равна последней
    {
        ThisDayOne = Day(
            when(Cell)
            {
                1->"Понедельник"
                2->"Вторник"
                3->"Среда"
                4->"Четверг"
                5->"Пятница"
                6->"Суббота"
                else->""
            }, mutableListOf())
        ThisDaySecond = Day(
            ThisDayOne.dayOfWeek, mutableListOf())
        while (Row <= NextRow)
        {
                    currentLesson = Lesson(
                        table.getRow(Row).getCell(Cell).toString().substringBefore(" "),
                        table.getRow(Row).getCell(Cell).toString().substringAfter("а."),
                        table.getRow(Row+1).getCell(Cell).toString().substringAfter("пр.кср.", "")
                                +table.getRow(Row+1).getCell(Cell).toString().substringAfter("лаб.", "")
                                +table.getRow(Row+1).getCell(Cell).toString().substringAfter("лек.", ""),
                        //table.getRow(Row+1).getCell(Cell).toString().split(regexp).toString(),
                        "",
                    )
                    Row = Row + 2
                    //ThisDayOne.classes.add(currentLesson)
            if(Row%4 == 0)
                ThisDayOne.classes.add(currentLesson)
            else
                ThisDaySecond.classes.add(currentLesson)
        }
        timeTable.upWeek.add(ThisDaySecond)
        timeTable.lowWeek.add(ThisDayOne)
        Cell++
        Row = start
    }
    return timeTable
}
//val teacherRepoDumpTestData = ReturnsArrayOfTeachers(tables as XSSFSheet)
