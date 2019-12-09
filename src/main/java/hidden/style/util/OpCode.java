package hidden.style.util;

public enum OpCode {

    ADDITION(1,4),
    MULTIPLICATION(2, 4),
    INPUT(3,2),
    OUTPUT(4,2),
    JUMP_IF_TRUE(5,3),
    JUMP_IF_FALSE(6,3),
    LESS_THAN(7,4),
    EQUALS(8,4),
    COMPLETED(99, 1);


    private int intCode;
    private int parameters;

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
