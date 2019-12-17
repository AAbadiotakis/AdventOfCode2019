package hidden.style.util;

public class IntCodeProgram {

    public static int decodeString(int[] intArray, Integer inputValue) throws Exception {
        int[] inputArray = intArray.clone();
        int i = 0;
        while(i < inputArray.length) {
            int aParamMode = inputArray[i] / 100 % 10;
            int bParamMode = inputArray[i] / 1000 % 10;
            int cParamMode = inputArray[i] / 10000 % 10;
            OpCode opCode = OpCode.matches(inputArray[i] % 100);
            switch(opCode) {
                case ADDITION:
                    inputArray[inputArray[i + 3]] = ((aParamMode == 1) ? inputArray[i + 1] : inputArray[inputArray[i + 1]])
                            + ((bParamMode == 1) ? inputArray[i + 2] : inputArray[inputArray[i + 2]]);
                    i += opCode.getParameters();
                    break;
                case MULTIPLICATION:
                    inputArray[inputArray[i + 3]] = ((aParamMode == 1) ? inputArray[i + 1] : inputArray[inputArray[i + 1]])
                            * ((bParamMode == 1) ? inputArray[i + 2] : inputArray[inputArray[i + 2]]);
                    i += opCode.getParameters();
                    break;
                case INPUT:
                    inputArray[inputArray[i + 1]] = inputValue;
                    i += opCode.getParameters();
                    break;
                case OUTPUT:
                    System.out.println("Output = " + inputArray[inputArray[i + 1]]);
                    i += opCode.getParameters();
                    break;
                case JUMP_IF_TRUE:
                    if((aParamMode == 1) ? inputArray[i + 1] != 0 : inputArray[inputArray[i + 1]] != 0) {
                        i = (bParamMode == 1) ? inputArray[i + 2] : inputArray[inputArray[i + 2]];
                    } else {
                        i += opCode.getParameters();
                    }
                    break;
                case JUMP_IF_FALSE:
                    if((aParamMode == 1) ? inputArray[i + 1] == 0 : inputArray[inputArray[i + 1]] == 0) {
                        i = (bParamMode == 1) ? inputArray[i + 2] : inputArray[inputArray[i + 2]];
                    } else {
                        i += opCode.getParameters();
                    }
                    break;
                case LESS_THAN:
                    if(((aParamMode == 1) ? inputArray[i + 1] : inputArray[inputArray[i + 1]])
                            < ((bParamMode == 1) ? inputArray[i + 2] : inputArray[inputArray[i + 2]])) {
                        inputArray[inputArray[i + 3]] = 1;
                    } else {
                        inputArray[inputArray[i + 3]] = 0;
                    }
                    i += opCode.getParameters();
                    break;
                case EQUALS:
                    if(((aParamMode == 1) ? inputArray[i + 1] : inputArray[inputArray[i + 1]])
                        == ((bParamMode == 1) ? inputArray[i + 2] : inputArray[inputArray[i + 2]])) {
                        inputArray[inputArray[i + 3]] = 1;
                    } else {
                        inputArray[inputArray[i + 3]] = 0;
                    }
                    i += opCode.getParameters();
                    break;
                case COMPLETED:
                    return inputArray[0];
            }
        }
        throw new Exception("Should not reach here");
    }
}
