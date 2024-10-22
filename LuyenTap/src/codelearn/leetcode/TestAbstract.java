package codelearn.leetcode;

abstract class TestAbstract {
    protected int number = 3;
    protected void printNumber() {
        System.out.println(number);
    }
    abstract void printNumberAbstract();
}
