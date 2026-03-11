from tkinter import *

# Global variable to store the current expression
expression = ""


# Function to update the expression in the text entry box
def press(num):
    global expression
    expression = expression + str(num)
    equation.set(expression)


# Function to evaluate the final expression (Postfix Evaluation)
def evaluate_postfix(postfix):
    stack = []
    for token in postfix:
        if token.isdigit():  # If token is a number, push it onto the stack
            stack.append(int(token))
        else:  # If token is an operator, pop two operands, apply the operator and push the result back
            operand2 = stack.pop()
            operand1 = stack.pop()
            if token == '+':
                stack.append(operand1 + operand2)
            elif token == '-':
                stack.append(operand1 - operand2)
            elif token == '*':
                stack.append(operand1 * operand2)
            elif token == '/':
                stack.append(operand1 / operand2)
    return stack[-1]  # Return the result


# Function to convert infix expression to postfix
def infix_to_postfix(infix):
    precedence = {'+': 1, '-': 1, '*': 2, '/': 2, '(': 0, ')': 0}
    stack = []  # To hold operators
    output = []  # To hold the postfix expression

    tokens = list(infix.replace(" ", ""))  # Remove spaces from the infix string

    i = 0
    while i < len(tokens):
        token = tokens[i]

        if token.isdigit():  # If token is a number, add it to the output list
            num = token
            while i + 1 < len(tokens) and tokens[i + 1].isdigit():  # Handle multi-digit numbers
                i += 1
                num += tokens[i]
            output.append(num)

        elif token == '(':  # If token is '(', push it onto the stack
            stack.append(token)

        elif token == ')':  # If token is ')', pop operators from the stack to output until '(' is found
            while stack and stack[-1] != '(':
                output.append(stack.pop())
            stack.pop()  # Pop '(' from the stack

        else:  # If token is an operator, pop operators with higher or equal precedence from the stack
            while stack and precedence.get(stack[-1], 0) >= precedence[token]:
                output.append(stack.pop())
            stack.append(token)

        i += 1

    # Pop all remaining operators from the stack to the output
    while stack:
        output.append(stack.pop())

    return output


# Function to evaluate the expression
def equalpress():
    global expression
    try:
        # Convert infix expression to postfix
        postfix = infix_to_postfix(expression)

        # Evaluate the postfix expression
        result = evaluate_postfix(postfix)

        equation.set(result)

        expression = ""
    except:
        equation.set("error")
        expression = ""


# Function to clear the contents of the text entry box
def clear():
    global expression
    expression = ""
    equation.set("")


# Driver code
if __name__ == "__main__":
    # Create the GUI window
    gui = Tk()

    # Set the background color of GUI window
    gui.configure(background="gray")

    # Set the title of GUI window
    gui.title("Advanced Calculator")

    # Set the configuration of GUI window
    gui.geometry("340x230")

    # Create a StringVar() instance for the equation variable
    equation = StringVar()

    # Create the text entry box for showing the expression
    expression_field = Entry(gui, textvariable=equation)

    # Grid method to place the widgets in respective positions
    expression_field.grid(columnspan=4, ipadx=70)

    equation.set('')

    # Create the buttons and place them at respective positions in the window
    button1 = Button(gui, text=' 1 ', fg='white', bg='blue', command=lambda: press(1), height=1, width=7)
    button1.grid(row=2, column=0)

    button2 = Button(gui, text=' 2 ', fg='white', bg='blue', command=lambda: press(2), height=1, width=7)
    button2.grid(row=2, column=1)

    button3 = Button(gui, text=' 3 ', fg='white', bg='blue', command=lambda: press(3), height=1, width=7)
    button3.grid(row=2, column=2)

    button4 = Button(gui, text=' 4 ', fg='white', bg='blue', command=lambda: press(4), height=1, width=7)
    button4.grid(row=3, column=0)

    button5 = Button(gui, text=' 5 ', fg='white', bg='blue', command=lambda: press(5), height=1, width=7)
    button5.grid(row=3, column=1)

    button6 = Button(gui, text=' 6 ', fg='white', bg='blue', command=lambda: press(6), height=1, width=7)
    button6.grid(row=3, column=2)

    button7 = Button(gui, text=' 7 ', fg='white', bg='blue', command=lambda: press(7), height=1, width=7)
    button7.grid(row=4, column=0)

    button8 = Button(gui, text=' 8 ', fg='white', bg='blue', command=lambda: press(8), height=1, width=7)
    button8.grid(row=4, column=1)

    button9 = Button(gui, text=' 9 ', fg='white', bg='blue', command=lambda: press(9), height=1, width=7)
    button9.grid(row=4, column=2)

    button0 = Button(gui, text=' 0 ', fg='white', bg='blue', command=lambda: press(0), height=1, width=7)
    button0.grid(row=5, column=0)

    plus = Button(gui, text=' + ', fg='white', bg='blue', command=lambda: press("+"), height=1, width=7)
    plus.grid(row=2, column=3)

    minus = Button(gui, text=' - ', fg='white', bg='blue', command=lambda: press("-"), height=1, width=7)
    minus.grid(row=3, column=3)

    multiply = Button(gui, text=' * ', fg='white', bg='blue', command=lambda: press("*"), height=1, width=7)
    multiply.grid(row=4, column=3)

    divide = Button(gui, text=' / ', fg='white', bg='blue', command=lambda: press("/"), height=1, width=7)
    divide.grid(row=5, column=3)

    equal = Button(gui, text=' = ', fg='white', bg='blue', command=equalpress, height=1, width=7)
    equal.grid(row=5, column=2)

    clear = Button(gui, text='Clear', fg='white', bg='blue', command=clear, height=1, width=7)
    clear.grid(row=5, column=1)

    # Add buttons for parentheses
    open_paren = Button(gui, text=' ( ', fg='white', bg='blue', command=lambda: press("("), height=1, width=7)
    open_paren.grid(row=6, column=0)

    close_paren = Button(gui, text=' ) ', fg='white', bg='blue', command=lambda: press(")"), height=1, width=7)
    close_paren.grid(row=6, column=1)

    # Start the GUI
    gui.mainloop()