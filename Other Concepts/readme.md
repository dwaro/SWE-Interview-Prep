# Concepts to Know

## Object Oriented Programming

### `Encapsulation`

### `Polymorphishm`

## Testing

### `Unit Testing`

### `System Testing`

### `Edge Cases`

## Bit Manipulation

In bit manipulation, we focus on performing bit-level comparisons. The following are the bit-wise operators to know:

- & - **AND**    True if both bits are 1.

- | - **OR**    True if at least one bit is 1.

- ^ - **XOR**    True if bits are different, i.e. 1 and 0.

- ~ - **NOT**    Reverses each bit in the binary numbers; it has potential to change the signage of the number. In
Java, the compiler will return the 2's complement of the inverse binary number of the decimal. e.g. 5 --> 101

- << - **Left Shift**    Shifts all bits left by the number expressed. All trailing spaces are filled with 0s. A shift by 1 is
equivalent to multiplying by 2. Shifting by 2 is equivalent to multiplying by 4. In other words, multiplying by 2^n
where n is the shift value.

- >> - **Right Shift**    Shifts all bits right by the number, n, expressed. If n is negative, the leading spaces will be filled
with 1s. If n is positive, they will be filled with 0s. We can also reduce this to an expression of dividing by 2^n.

- >>> - **Unsigned Right Shift**    In this case, regardless of n's signage, the leading spaces will be filled with 0s, always
creating a positive number.


