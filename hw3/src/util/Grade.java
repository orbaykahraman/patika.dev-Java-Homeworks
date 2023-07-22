package util;

public enum Grade {

    F("F",0),
    D("D",1),
    C("C",2),
    B("B",3),
    A("A",4);

    public final String stringValue;
    public final int numericValue;

    Grade(String stringValue, int numericValue) {
        this.stringValue = stringValue;
        this.numericValue = numericValue;
    }

    @Override
    public String toString() {
        return "Grade : " + getStringValue() + " corresponds to numeric grade " + getNumericValue() + ".";
    }

    public String getStringValue() {
        return stringValue;
    }

    public int getNumericValue() {
        return numericValue;
    }


}
