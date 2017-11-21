package com.calculator.domain;

public class ComplexObject {

    private int valueA;
    private int valueB;
    private Service service;

    public ComplexObject() {
    }

    public ComplexObject(int valueA, int valueB, Service service) {
        this.valueA = valueA;
        this.valueB = valueB;
        this.service = service;
    }

    public int getValueA() {
        return valueA;
    }

    public void setValueA(int valueA) {
        this.valueA = valueA;
    }

    public int getValueB() {
        return valueB;
    }

    public void setValueB(int valueB) {
        this.valueB = valueB;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplexObject that = (ComplexObject) o;

        if (valueA != that.valueA) return false;
        if (valueB != that.valueB) return false;
        return service == that.service;
    }

    @Override
    public int hashCode() {
        int result = valueA;
        result = 31 * result + valueB;
        result = 31 * result + (service != null ? service.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ComplexObject{" +
                "valueA=" + valueA +
                ", valueB=" + valueB +
                ", service=" + service +
                '}';
    }
}
