package hidden.style.util;

public class IntCodeProgram {

    public static int decodeString(String[] inputArray, Integer inputValue) {
        int i = 0;
        while(true) {
            String initialOpCode = inputArray[i];
            int parameterModeForParam1 = 0;
            int parameterModeForParam2 = 0;
            int parameterModeForParam3 = 0;
            OpCode opCode = null;
            if(initialOpCode.length() > 2) {
                if(initialOpCode.length() == 3) {
                    parameterModeForParam1 = Integer.parseInt(initialOpCode.substring(0,1));
                    opCode = OpCode.matches(Integer.parseInt(initialOpCode.substring(1)));
                } else if(initialOpCode.length() == 4) {
                    parameterModeForParam2 = Integer.parseInt(initialOpCode.substring(0,1));
                    parameterModeForParam1 = Integer.parseInt(initialOpCode.substring(1,2));
                    opCode = OpCode.matches(Integer.parseInt(initialOpCode.substring(2)));
                } else if(initialOpCode.length() == 5) {
                    parameterModeForParam3 = Integer.parseInt(initialOpCode.substring(0,1));
                    parameterModeForParam2 = Integer.parseInt(initialOpCode.substring(1,2));
                    parameterModeForParam1 = Integer.parseInt(initialOpCode.substring(2,3));
                    opCode = OpCode.matches(Integer.parseInt(initialOpCode.substring(3)));
                }
            } else {
                opCode = OpCode.matches(Integer.parseInt(initialOpCode));
            }
            if(opCode.equals(OpCode.COMPLETED)) {
                return Integer.parseInt(inputArray[0]);
            }
            Integer param1 = null;
            Integer param2 = null;
            Integer param3 = null;
            for (int j = 0; j < opCode.getParameters(); j++) {
                if(j == 0) {
                    i++;
                    if(parameterModeForParam1 == 1 || opCode == OpCode.INPUT) {
                        param1 = Integer.parseInt(inputArray[i]);
                    } else {
                        param1 = Integer.parseInt(inputArray[Integer.parseInt(inputArray[i])]);
                    }
                } else if(j == 1) {
                    i++;
                    if(parameterModeForParam2 == 1) {
                        param2 = Integer.parseInt(inputArray[i]);
                    } else {
                        param2 = Integer.parseInt(inputArray[Integer.parseInt(inputArray[i])]);
                    }
                } else if(j == 2) {
                    i++;
                    if(parameterModeForParam3 == 1 || opCode == OpCode.ADDITION || opCode == OpCode.MULTIPLICATION || opCode == OpCode.LESS_THAN || opCode == OpCode.EQUALS) {
                        param3 = Integer.parseInt(inputArray[i]);
                    } else {
                        param2 = Integer.parseInt(inputArray[Integer.parseInt(inputArray[i])]);
                    }
                }
            }
            switch(opCode) {
                case ADDITION:
                    inputArray[param3] = String.valueOf(param1 + param2);
                    i++;
                    break;
                case MULTIPLICATION:
                    inputArray[param3] = String.valueOf(param1 * param2);
                    i++;
                    break;
                case INPUT:
                    inputArray[param1] = String.valueOf(inputValue);
                    i++;
                    break;
                case OUTPUT:
                    if(param1 != 0) {
                        return param1;
                    }
                    i++;
                    break;
                case JUMP_IF_TRUE:
                    if(param1 != 0) {
                        i = param2;
                    } else {
                        i++;
                    }
                    break;
                case JUMP_IF_FALSE:
                    if(param1 == 0) {
                        i = param2;
                    } else {
                        i++;
                    }
                    break;
                case LESS_THAN:
                    if(param1 < param2) {
                        inputArray[param3] = String.valueOf(1);
                    } else {
                        inputArray[param3] = String.valueOf(0);
                    }
                    i++;
                    break;
                case EQUALS:
                    if(param1 == param2) {
                        inputArray[param3] = String.valueOf(1);
                    } else {
                        inputArray[param3] = String.valueOf(0);
                    }
                    i++;
                    break;
            }
        }
    }

}
