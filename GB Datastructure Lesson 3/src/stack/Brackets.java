package stack;

public class Brackets {
    public static void main(String[] args) {
        String text = " public E peek(] { if (isEmpty()){ return null; } return data[size-1];  ";
        new Brackets(text).check();
    }

    private final String codeText;

    public Brackets(String codeText) {
        this.codeText = codeText;
    }

    public void check() {

        Stack<Character> stack = new MyStackImpl<>(codeText.length());

        for (int index = 0; index < codeText.length(); index++) {
            checkCurrentChar(stack, index, codeText.charAt(index));
        }
        if (!stack.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }

    private void checkCurrentChar(Stack<Character> stack, int index, char currentChar) {
        switch (currentChar) {

            case '[':
            case '{':
            case '(':
                stack.push(currentChar);
                break;
            case ']':
            case '}':
            case ')':
                if (stack.isEmpty()) {
                    showError(index, currentChar);
                    break;

                }
                Character lastOpenedBracket = stack.pop();
                if (lastOpenedBracket == '[' && currentChar != ']' ||
                        lastOpenedBracket == '{' && currentChar != '}' ||
                        lastOpenedBracket == '(' && currentChar != ')'
                ) {
                    showError(index, currentChar);
                    break;
                }
            default:
                break;
        }
    }

    private void showError(int index, char currentChar) {
        System.out.printf("Error:  %s at %d%n", currentChar, index);
    }
}
