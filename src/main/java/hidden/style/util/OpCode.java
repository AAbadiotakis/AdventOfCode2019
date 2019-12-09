package hidden.style.util;

public enum OpCode {

    ADDITION(1,3),
    MULTIPLICATION(2, 3),
    INPUT(3,1),
    OUTPUT(4,1),
    JUMP_IF_TRUE(5,2),
    JUMP_IF_FALSE(6,2),
    LESS_THAN(7,3),
    EQUALS(8,3),
    COMPLETED(99, 0);


    int intCode;
    int parameters;

    OpCode(int intCode, int parameters) {
        this.intCode = intCode;
        this.parameters = parameters;
    }

    public int getIntCode() { return intCode; }
    public int getParameters() { return parameters; }

    public static OpCode matches(int intCode) {
        for (OpCode ic : OpCode.values()) {
            if(ic.getIntCode() == intCode) {
                return ic;
            }
        }
        return null;
    }

}
