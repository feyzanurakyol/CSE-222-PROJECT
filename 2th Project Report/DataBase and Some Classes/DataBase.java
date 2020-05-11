package com.Akif;

import java.util.LinkedList;
import java.util.Stack;

public class DataBase {
    private LinkedList<DailyFoodMenu> menuList;
    private Queue<Visitor> visitors;
    private Queue<ToDo> toDos;
    private Stack<HealthAppointment> healthAppointments;  //-Stack can be Deque-
    BinarySearchTree<Inmate> prisoners;
    BinarySearchTree<Personnel> allPersonnel;

    //All operations will come here...(add,remove update etc.)

}
