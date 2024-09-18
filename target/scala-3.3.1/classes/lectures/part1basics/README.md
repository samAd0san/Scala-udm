# Variables, Values and Types
- Learnt how to use basic types.
- val declares an immutable variable (constant).
- var declares a mutable variable (can be reassigned).
- <b>val</b> is preferred over <b>var</b>.
- <b> Compilers automatically infers types when not mentioned </b>

# Expressions
- We covered Basic expressions and operators.
- 'if' statement in Scala is an expression.
- 'CodeBlocks' in Scala are expression, the value of the box is the value of the last expression inside it.
- In <b>Scala</b> we think everything in terms of expression.

# Functions 
- We should declare the parameter with types always.
- If the return type is not mentioned, the compiler can infer the type. (only in non-recursive function).
- since expressions are wrapped in braces '{}', we can use braces in functions.
- If you want to use a while loop, use recursion (while loop is depreciated)

# Recursion
- <b>Tail Recursion</b> is a form of recursion where the recursive call is the last operation in the function, allowing the compiler to optimize it to use constant stack space.
- We use tail recursion in Scala to improve performance and prevent stack overflow errors in deeply recursive functions.