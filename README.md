
101 LINQ Samples in Java
========================

Port of the [C# 101 LINQ Samples](http://code.msdn.microsoft.com/101-LINQ-Samples-3fb9811b) rewritten into modern C# syntax and then also using Java, using built in methods where possible.

Source for both C# and Java are included in the [src](src) folder in this repository

- To run the respective C# projects (*.csproj*), open the containing folder in [Visual Studio Code](https://code.visualstudio.com/) use the Debug command 

  
### Operation Comparison Matrix

**Note**: All Java functional methods operate off a stream().  All these methods listed below must be preceded by the `stream()` method.

For Example
```java
    collection.stream().filter();
```

|Operation|C#|Java|
|---------|--|----|
|**Filter**|`Where`|`filter(predicate)`|
|**Projection**|`Select`|`map(lambda)`|
||`SelectMany`|`.flatmap(lambda)`|
|**Partitioning**|`Take(n)`|`.limit(n`|
||`TakeWhile(predicate)`|`takewhile(predicate)`|
||`Skip(n)`|`array[n:]`|
||`SkipWhile(predicate)`|`dropwhile(predicate, sequence)`|
|**Ordering**|`OrderBy`|`sorted()`|
||`OrderBy(lambda)`|`sorted(lambda)`||
||`OrderByDescending`|`sorted(Comparator.comparing(lamda, Comparator.reverseOrder()))`|
||`OrderByDescending(lambda)`|`sorted(Comparator.comparing(lamda, Comparator.reverseOrder()))`|
||`ThenBy`|`sorted(Comparator).comparing(lambda).thenComparing(lambda))`|
||`ThenByDescending`|`sorted(Comparator).comparing(lambda).thenComparing(lambda), Comparator.reverseOrder()))`|
||`Reverse`|`collect(Collectors.toCollection(LinkedList::new)).descendingIterator();`|
|**Grouping**|`GroupBy`|`.collect(Collectors.groupingBy(lamnda, Collectors.toList()))`|
|**Sets**|`Distinct`|`distinct`|
||`Union`|`Stream.Concat(stream1, stream2).distinct()`|
||`Interect`|`streamA.filter(a ->  streamB.anyMatch(b -> b == a))`|
||`Except`|`streamA.filter(a ->  streamB.nonMatch(b -> b == a))`|
|**Conversion**|`ToArray`|`toArray`|
||`ToList`|`collect(Collectors.list)`|
||`ToDictionary`|`collect(Collectors.toMap(lambdaKey, lambdaValue))`|
||`OfType`|`filter(Type.class::isInstance)`|
|**Element**|`First`|`findFirst`|
||`First(predicate)`|`filter(predicate).findFirst()`|
||`FirstOrDefault`|`findFirst().orElse(default)`|
||`FirstOrDefault(predicate)`|`filter(predicate).findFirst().orElse(default)`|
||`ElementAt(n)`|`toArray().[n]`|
|**Generation**|`Enumerable.Range()`|` IntStream.range()`|
||`Enumerable.Repeat(x, n)`|`Arrays.fill(array[n], x)`|
|**Quantifiers**|`Any(predicate)`|`any(predicate)`|
||`All(predicate)`|`all(predicate)`|
|**Aggregate**|`Count`|`len` |
||`Count(lamda)`|`filter(predicate).count()`|
||`Sum`|`sum`|
||`Min`|`min`|
||`Max`|`max`|
||`Avg`|||
||`Sum(predicate)`|`filter(predicate).collect(Collectors.summingInt)`|
||`Min(predicate)`|`filter(predicate).collect(Collectors.minBy)`|
||`Max(predicate)`|`filter(predicate).collect(Collectors.maxBy)`|
||`Avg(predicate)`|
||`Aggregate`|`reduce(lambda)`|
||`Aggregate(seed, lamda)`|`reduce(lambsa,seed)`|
|**Miscellaneous**|`Concat(IEnumerable)`|`concat(stream1, stream2)`|
||`SequenceEqual(IEnumerable)`|`Arrays.Equal(array1,array2)` <br /> `list1.equals(list2)`|

#### Source
|Operation/Section|Java Source|C# Source|
|-----------------|-------------|---------|
|[Filter](#linq1-where---simple-1)|[LinqFilters.java](src/java/LinqSamples101/src/main/java/linq/LinqFilters.java)|[linq-restrictions/Program.cs](src/csharp/linq-restrictions/Program.cs)|
|[Projection](#linq---projection-operators)|[LinqProjections.java](src/java/LinqSamples101/src/main/java/linq/LinqProjections.java)|[linq-projections/Program.cs](src/csharp/linq-projections/Program.cs)|
|[Partitioning](#linq---partitioning-operators)|[LinqPartitions.java](src/java/LinqSamples101/src/main/java/linq/LinqPartitions.java)|[linq-partitioning/Program.cs](src/csharp/linq-partitioning/Program.cs)|
|[Ordering](#linq---ordering-operators)|[LinqOrdering.java](src/java/LinqSamples101/src/main/java/linq/LinqOrdering.java)|[linq-ordering/Program.cs](src/csharp/linq-ordering/Program.cs)|
|[Grouping](#linq---grouping-operators)|[LinqGrouping.java](src/java/LinqSamples101/src/main/java/linq/LinqGrouping.java)|[linq-grouping/Program.cs](src/csharp/linq-grouping/Program.cs)|
|[Set](#linq---set-operators)|[LinqSets.java](src/java/LinqSamples101/src/main/java/linq/LinqSets.java)|[linq-sets/Program.cs](src/csharp/linq-sets/Program.cs)|
|[Conversion](#linq---conversion-operators)|[LinqConversion.java](src/java/LinqSamples101/src/main/java/linq/LinqConversion.java)|[linq-conversion/Program.cs](src/csharp/linq-conversion/Program.cs)|
|[Element](#linq---element-operators)|[LinqElements.java](src/java/LinqSamples101/src/main/java/linq/LinqElements.java)|[linq-element/Program.cs](src/csharp/linq-element/Program.cs)|
|[Generation](#linq---generation-operators)|[LinqGeneration.java](src/java/LinqSamples101/src/main/java/linq/LinqGeneration.java)|[linq-generation/Program.cs](src/csharp/linq-generation/Program.cs)|
|[Quantifiers](#linq---quantifiers)|[LinqQuantifiers.java](src/java/LinqSamples101/src/main/java/linq/LinqQuantifiers.java)|[linq-quantifiers/Program.cs](src/csharp/linq-quantifiers/Program.cs)|
|[Aggregate](#linq---aggregate-operators)|[LinqAggregate.java](src/java/LinqSamples101/src/main/java/linq/LinqAggregate.java)|[linq-aggregate/Program.cs](src/csharp/linq-aggregate/Program.cs)|
|[Miscellaneous](#linq---miscellaneous-operators)|[LinqMiscellaneous.java](src/java/LinqSamples101/src/main/java/linq/LinqMiscellaneous.java)|[linq-miscellaneous/Program.cs](src/csharp/linq-miscellaneous/Program.cs)|
|[Query](#linq---query-execution)|[LinqQuery.java](src/java/LinqSamples101/src/main/java/linq/LinqQuery.java)|[linq-query/Program.cs](src/csharp/linq-query/Program.cs)|

##  Side-by-side - C# LINQ vs Java functional collections

For a side-by-side comparison, the original **C#** source code is displayed above the equivalent **Java** translation. 

  - The **Output** shows the console output of running the **Java** sample. 
  - Java 10 is used here for the use of [Anonymous Classes as shown here](https://stackoverflow.com/a/51210871/168925), although `stream()`, wich is used mostly in these functional examples, used in functional programming, was introduced in Java 8.
  - The Java 10 var keyword is used for brevity of declaring types
  - Where a problem as not been able to be solved in Java, its implementation has a `print("TODO")` line.
  - Outputs ending with `...` illustrates only a partial response is displayed. 
  - The source-code for C# and Java utils used are included once under the first section they're used in.
  - The C# ObjectDumper util used is downloadable from MSDN - [ObjectDumper.zip](http://code.msdn.microsoft.com/Visual-Studio-2008-C-d295cdba/file/46086/1/ObjectDumper.zip)

  
LINQ - Filter Operators
-----------------------

### linq1: Where - Simple 1
> This sample uses a filter to find all elements of an array with a value less than 5.

```csharp
//c#
static void Linq1()
{
    var numbers = new [] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var lowNums = numbers.Where(n => n < 5);

    Console.WriteLine("Numbers < 5:");
    lowNums.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq1() {
    var numbers = new int[]{5, 4, 1, 3, 9, 8, 6, 7, 2, 0};

    var lownumbers = Arrays.stream(numbers)
            .filter(x -> x < 5);

    print("Numbers < 5:");
    lownumbers.forEach(System.out::println);
}
```
#### Output

    Numbers < 5:
    4
    1
    3
    2
    0
  
### linq2: Where - Simple 2
>This sample uses a filter to find all products that are out of stock.
```csharp
//c#
static void Linq2()
{
    var products = GetProductList();

    var soldOutProducts = products.Where(p => p.UnitsInStock == 0);

    Console.WriteLine("Sold out products:");
    soldOutProducts.ForEach(x => Console.WriteLine($"{x.ProductName} is sold out!"));
}
```
```java
//java
public static void Linq2() {
    var products = Data.getProductList();

    var sold_out_products = products.stream()
            .filter(p -> p.unitsInStock == 0);

    print("Sold out products:");
    sold_out_products.forEach(p -> print("%s is sold out!", p.productName));
}
```
#### Output

    Sold out products:
    Chef Anton's Gumbo Mix is sold out!
    Alice Mutton is sold out!
    Th�ringer Rostbratwurst is sold out!
    Gorgonzola Telino is sold out!
    Perth Pasties is sold out!

### linq3: Where - Simple 3
>This sample uses a filter to find all products that are in stock and cost more than 3.00 per unit.
```csharp
//c#
public static void Linq3()
{
    var products = GetProductList();

    var expensiveInStockProducts = products.Where(p => p.UnitsInStock > 0 && p.UnitPrice > 3.00M);

    Console.WriteLine("In-stock products that cost more than 3.00:");
    expensiveInStockProducts.ForEach(product => Console.WriteLine($"{product.ProductName} is in stock and costs more than 3.00."));
}
```
```java
//java
public static void Linq3() {
    var products = Data.getProductList();

    var sold_out_products = products.stream()
            .filter(p -> p.unitsInStock > 0 && p.unitPrice > 3.00);

    print("In-stock products that cost more than 3.00:");
    sold_out_products.forEach(p -> print("%s is in stock and costs more than 3.00.", p.productName));
}
```
#### Output

    In-stock products that cost more than 3.00:
    Chai is in stock and costs more than 3.00.
    Chang is in stock and costs more than 3.00.
    Aniseed Syrup is in stock and costs more than 3.00.
    ...

### linq4: Where - Drilldown
>This sample uses a filter to find all customers in Washington and then it uses a foreach loop to iterate over the orders collection that belongs to each customer.
```csharp
//c#
static void Linq4()
{
    var customers = GetCustomerList();

    Console.WriteLine("Customers from Washington and their orders:");
    var waCustomers = customers.Where(c => c.Region == "WA");

    waCustomers.ForEach((customer) =>
    {
        Console.WriteLine($"Customer {customer.CustomerID}: {customer.CompanyName}");
        customer.Orders.ForEach((order) => 
        {
            Console.WriteLine($"  Order {order.OrderID}: {order.OrderDate}");
        });
    });
}
```
```java
//java
public static void Linq4() {
    var customers = Data.getCustomerList();

    var waCustomers = customers.stream()
            .filter(c -> "WA".equals(c.region));

    print("Customers from Washington and their orders:");
    waCustomers.forEach(c -> {
        print(String.format("%s : %s", c.customerId, c.companyName));
        c.orders.forEach(o -> print("     Order %s: %s\"", o.orderId, o.orderDate));
    });
}
```
#### Output

    Customers from Washington and their orders:
    LAZYK : Lazy K Kountry Store
        Order 10482: Fri Mar 21 02:00:00 SAST 1997"
        Order 10545: Thu May 22 02:00:00 SAST 1997"
    TRAIH : Trail's Head Gourmet Provisioners
        Order 10574: Thu Jun 19 02:00:00 SAST 1997"
        Order 10577: Mon Jun 23 02:00:00 SAST 1997"
        Order 10822: Thu Jan 08 02:00:00 SAST 1998"
    WHITC : White Clover Markets
        Order 10269: Wed Jul 31 02:00:00 SAST 1996"
        Order 10344: Fri Nov 01 02:00:00 SAST 1996"
    ...

### linq5: Where - Indexed
>This sample demonstrates an indexed filter that returns digits whose name is shorter than their value.
```csharp
//c#
static void Linq5()
{
    var digits = new[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var shortDigits = digits.Where((digit, index) => digit.Length < index);

    Console.WriteLine("Short digits:");
    shortDigits.ForEach(d => Console.WriteLine($"The word {d} is shorter than its value."));
}
```
```java
//java
public static void Linq5() {
    var digits = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var shortDigits = IntStream.range(0, digits.length)
            .mapToObj(index -> new Object() {
                int Index = index;
                String Digit = digits[index];
            })
            .filter(o -> o.Digit.length() < o.Index);

    print("Short digits:");
    shortDigits.forEach(o -> print("The word %s is shorter than its value", o.Digit));
}
```
#### Output

    Short digits:
    The word five is shorter than its value.
    The word six is shorter than its value.
    The word seven is shorter than its value.
    The word eight is shorter than its value.
    The word nine is shorter than its value.


LINQ - Projection Operators
---------------------------

### linq6: Select - Simple 1
>This sample projects a sequence of ints 1+ higher than those in an existing array of ints.
```csharp
//c#
static void Linq6()
{
    var numbers = new[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var numsPlusOne = numbers.Select(n => n + 1);

    Console.WriteLine("Numbers + 1:");
    numsPlusOne.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq6() {
    var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var lownumbers = Arrays.stream(numbers)
            .boxed()
            .map(n -> n +1);

    print("Numbers +1:");
    lownumbers.forEach(System.out::println);
}
```
#### Output

    Numbers + 1:
    6
    5
    2
    4
    10
    9
    7
    8
    3
    1

### linq7: Select - Simple 2
>This sample projects a sequence of just the names of a list of products.
```csharp
//c#
static void Linq7()
{
    var products = GetProductList();

    var productNames = products.Select(p => p.ProductName);

    Console.WriteLine("Product Names:");
    productNames.ForEach(Console.WriteLine);
}
```
```java
//java
public static void  Linq7() {
    var products = Data.getProductList();

    var productNames = products.stream()
            .map(p -> p.productName);

    print("Product Names:");
    productNames.forEach(System.out::println);
}
```
#### Output

    Product Names:
    Chai
    Chang
    Aniseed Syrup
    Chef Anton's Cajun Seasoning
    Chef Anton's Gumbo Mix
    ...

### linq8: Select - Transformation
>This sample projects a sequence of strings representing the text version of a sequence of integers.
```csharp
//c#
static void Linq8()
{
    var numbers = new[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
    var strings = new [] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var textNums = numbers.Select(n => strings[n]);

    Console.WriteLine("Number strings:");
    textNums.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq8() {
    var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
    var strings = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var stringNums = Arrays.stream(numbers)
            .boxed()
            .map(n -> strings[n]);

    print("Number strings:");
    stringNums.forEach(System.out::println);
}
```
#### Output

    Number strings:
    five
    four
    one
    three
    nine
    eight
    six
    seven
    two
    zero

### linq9: Select - Anonymous Types 1
>"This sample projects a sequence of the uppercase and lowercase versions of each word in the original array.
```csharp
//c#
static void Linq9()
{
    var words = new[] { "aPPLE", "BlUeBeRrY", "cHeRry" };

    var upperLowerWords = words.Select(w => 
        new
        {
            Upper = w.ToUpper(), 
            Lower = w.ToLower()
        });

    upperLowerWords.ForEach(ul => Console.WriteLine($"Uppercase: {ul.Upper}, Lowercase: {ul.Lower}"));
}
```
```java
//java
public static void Linq9() {
    var words = new String[] { "aPPLE", "BlUeBeRrY", "cHeRry" };

    var upperLowerWords = Arrays.stream(words)
            .map(w -> new Object() {
                String upper = w.toUpperCase();
                String lower = w.toLowerCase();
            });

    upperLowerWords.forEach(word -> print("Uppercase: %s, Lowercase: %s", word.upper, word.lower));
}
```
#### Output

    Uppercase: APPLE, Lowercase: apple
    Uppercase: BLUEBERRY, Lowercase: blueberry
    Uppercase: CHERRY, Lowercase: cherry

### linq10: Select - Anonymous Types 2
>This sample projects a sequence containing text representations of digits and whether their length is even or odd.
```csharp
//c#
static void Linq10()
{
    var numbers = new[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
    var strings = new[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var digitOddEvens = numbers.Select(n => 
        new
        {
            Digit = strings[n], 
            Even = (n % 2 == 0)
        });
    
    digitOddEvens.ForEach(d => Console.WriteLine($"The digit {d.Digit} is {(d.Even ? "even" : "odd")}."));
}
```
```java
//java
public static void Linq10() {
    var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
    var strings = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var digitOddEvens = Arrays.stream(numbers)
            .boxed()
            .map(n -> new Object() {
                String Digit = strings[n];
                Boolean Even = n % 2 == 0;
            });

    digitOddEvens.forEach(o -> print("The digit %s is %s", o.Digit, o.Even ? "even" : "odd"));
}
```
#### Output

    The digit five is odd.
    The digit four is even.
    The digit one is odd.
    The digit three is odd.
    The digit nine is odd.
    The digit eight is even.
    The digit six is even.
    The digit seven is odd.
    The digit two is even.
    The digit zero is even.

### linq11: Select - Anonymous Types 3
>This sample projects a sequence containing some properties of Products, including UnitPrice which is renamed to Price in the resulting type.
```csharp
//c#
static void Linq11()
{
    var products = GetProductList();

    var productInfos = products.Select(p => 
        new
        {
            p.ProductName, 
            p.Category, 
            Price = p.UnitPrice
        });

    Console.WriteLine("Product Info:");
    productInfos.ForEach(productInfo => Console.WriteLine($"{productInfo.ProductName} is in the category {productInfo.Category} and costs {productInfo.Price} per unit."));
}
```
```java
//java
public static void Linq11() {
    var products = Data.getProductList();

    var productInfos = products.stream()
            .map(p -> new Object() {
                String ProductName = p.productName;
                String Category = p.category;
                Double Price = p.unitPrice;
            });

    print("Product Info:");
    productInfos.forEach(product -> print("%s is in the category %s and costs %.2f per unit.", product.ProductName, product.Category, product.Price));
}
```
#### Output

    Product Info:
    Chai is in the category Beverages and costs 18.0 per unit.
    Chang is in the category Beverages and costs 19.0 per unit.
    Aniseed Syrup is in the category Condiments and costs 10.0 per unit.
    ...

### linq12: Select - Indexed
>This sample uses an indexed projection to determine if the value of integers in an array match their position in the array.
```csharp
//c#
static void Linq12()
{
    var numbers = new[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var numsInPlace = numbers.Select((num, index) => 
        new
        {
            Num = num, 
            InPlace = (num == index)
        });

    Console.WriteLine("Number: In-place?");
    numsInPlace.ForEach(n => Console.WriteLine($"{n.Num}: {n.InPlace}"));
}
```
```java
//java
public static void Linq13() {
    var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
    var digits = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var lowNums = Arrays.stream(numbers)
            .boxed()
            .filter(n -> n < 5)
            .map(n -> digits[n]);

    print("Numbers < 5:");
    lowNums.forEach(System.out::println);
}
```
#### Output

    Number: In-place?
    5: false
    4: false
    1: false
    3: true
    9: false
    8: false
    6: true
    7: true
    2: false
    0: false

### linq13: Select - Filtered
>This sample first filters, then projects to make a simple query that returns the text form of each digit less than 5.
```csharp
//c#
static void Linq13()
{
    var numbers = new []{ 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
    var  digits = new [] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var lowNums = numbers
        .Where(n => n < 5)
        .Select(n => digits[n]);

    Console.WriteLine("Numbers < 5:");
    lowNums.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq13() {
    var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
    var digits = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var lowNums = Arrays.stream(numbers)
            .boxed()
            .filter(n -> n < 5)
            .map(n -> digits[n])
            .collect(Collectors.toList());

    print("Numbers < 5:");
    lowNums.forEach(System.out::println);
}
```
#### Output

    Numbers < 5:
    four
    one
    three
    two
    zero

### linq14: SelectMany - Compound from 1
>This sample projects a combination of 2 source arrays, then filters all pairs of numbers from both arrays such that the number from numbersA is less than the number from numbersB.
```csharp
//c#
static void Linq14()
{
    var numbersA = new [] { 0, 2, 4, 5, 6, 8, 9 };
    var numbersB = new []{ 1, 3, 5, 7, 8 };

    var pairs = numbersA
        .SelectMany(a => numbersB, (a, b) => new { a, b })
        .Where(x => x.a < x.b);

    Console.WriteLine("Pairs where a < b:");
    pairs.ForEach(pair => Console.WriteLine("{0} is less than {1}", pair.a, pair.b));
}
```
```java
//java
public static void Linq14() {
    var numbersA = new Integer[] { 0, 2, 4, 5, 6, 8, 9 };
    var numbersB = new Integer[]{ 1, 3, 5, 7, 8 };
    
    System.out.println("Pairs where a < b:");
    
    Arrays.stream(numbersA)
            .flatMap(a -> Arrays.stream(numbersB).map(b -> new Object(){
                Integer numberA = a; Integer numberB = b;
            }))
            .filter(pair -> pair.numberA < pair.numberB)
            .forEach(pair -> System.out.println(pair.numberA + " is less than "+ pair.numberB));
}
```
#### Output

    Pairs where a < b:
    0 is less than 1
    0 is less than 3
    0 is less than 5
    0 is less than 7
    0 is less than 8
    2 is less than 3
    2 is less than 5
    2 is less than 7
    2 is less than 8
    4 is less than 5
    4 is less than 7
    4 is less than 8
    5 is less than 7
    5 is less than 8
    6 is less than 7
    6 is less than 8

### linq15: SelectMany - Compound from 2
>TThis sample uses a nested projection to flatten the customer orders, then filtes the order total is less than 500.00.
```csharp
//c#
static void Linq15()
{
    var customers = GetCustomerList();

    var orders = customers
        .SelectMany(customer => customer.Orders, (customer, order) => new { customer, order })
        .Where(x => x.order.Total < 500.00M)
        .Select(x => 
            new
            {
                x.customer.CustomerID, 
                x.order.OrderID, 
                x.order.Total
            });

    ObjectDumper.Write(orders);
}
```
```java
//java
public static void Linq15() {
    List<Customer> customers = Data.getCustomerList();
    customers.stream()
            .filter(c -> c.orders != null)
            .flatMap(c -> c.orders.stream().map(o -> new Object(){
                    final String customerID = c.customerId;
                    final Integer orderId = o.orderId;
                    final Double total = o.total;
                }))
            .filter(o -> o.total < 500.00)
            .forEach(o -> System.out.println("{CustomerId: " + o.customerID +
                                                ", OrderId: " + o.orderId +
                                                ", Total: " + o.total));
}
```
#### Output

    {CustomerId: ALFKI, OrderId: 10702, Total: 330.0}
    {CustomerId: ALFKI, OrderId: 10952, Total: 471.2}
    {CustomerId: ANATR, OrderId: 10308, Total: 88.8}
    {CustomerId: ANATR, OrderId: 10625, Total: 479.75}
    ...

### linq16: SelectMany - Compound from 3
>This sample uses a nested projection to flatten the customer orders, the filters all orders that was made in 1998 or later.
```csharp
//c#
static void Linq16()
{
    var customers = GetCustomerList();

    var orders = customers
        .SelectMany(customer => customer.Orders, (customer, order) => new { customer, order })
        .Where(x => x.order.OrderDate >= new DateTime(1998, 1, 1))
        .Select(x => 
            new
            {
                x.customer.CustomerID, 
                x.order.OrderID, 
                x.order.OrderDate
            });

    ObjectDumper.Write(orders);
}
```
```java
//java
public static void Linq16() {
    List<Customer> customers = Data.getCustomerList();
    Date comparisonDate = new GregorianCalendar(1998, 1, 1).getTime();
    customers.stream()
            .filter(c -> c.orders != null && c.orders.size() > 0)
            .flatMap(c -> c.orders.stream().map(o -> new Object(){
                final String customerID = c.customerId;
                final Integer orderId = o.orderId;
                final Date orderDate = o.orderDate;
            }))
            .filter(o -> o.orderDate.compareTo(comparisonDate) >= 0 )
            .forEach(o -> System.out.println("{CustomerId: " + o.customerID +
                    ", OrderId: " + o.orderId +
                    ", OrderDate: " + o.orderDate));
}
```
#### Output

    {CustomerId: ALFKI, OrderId: 10835, OrderDate: 1998-01-15 00:00:00.000}
    {CustomerId: ALFKI, OrderId: 10952, OrderDate: 1998-03-16 00:00:00.000}
    {CustomerId: ALFKI, OrderId: 11011, OrderDate: 1998-04-09 00:00:00.000}
    {CustomerId: ANATR, OrderId: 10926, OrderDate: 1998-03-04 00:00:00.000}
    {CustomerId: ANTON, OrderId: 10856, OrderDate: 1998-01-28 00:00:00.000}
    ...

### linq17: SelectMany - from Assignment
>This sample uses a nested projection to flatten the customer orders, then filters the orders where the order total is greater than 2000.00.
```csharp
//c#
static void Linq17()
{
    var customers = GetCustomerList();

    var orders = customers
        .SelectMany(customer => customer.Orders, (customer, order) => new { customer, order })
        .Where(x => x.order.Total >= 2000.00M)
        .Select(x => 
            new
            {
                x.customer.CustomerID,
                x.order.OrderID, 
                x.order.Total
            });

    ObjectDumper.Write(orders);
}
```
```java
//java
public static void Linq17() {
    List<Customer> customers = Data.getCustomerList();
    customers.stream()
            .filter(c -> c.orders != null && c.orders.size() > 0)
            .flatMap(c -> c.orders.stream().map(o -> new Object(){
                final String customerID = c.customerId;
                final Integer orderId = o.orderId;
                final Double total = o.total;
            }))
            .filter(o -> o.total > 2000 )
            .forEach(o -> System.out.println("{CustomerId: " + o.customerID +
                    ", OrderId: " + o.orderId +
                    ", Total: " + o.total));
}
```
#### Output

    (customer_id='ANTON', order_id=10573, total=2082.0)
    (customer_id='AROUT', order_id=10558, total=2142.9)
    (customer_id='AROUT', order_id=10953, total=4441.25)
    (customer_id='BERGS', order_id=10384, total=2222.4)
    (customer_id='BERGS', order_id=10524, total=3192.65)
    ...

### linq18: SelectMany - Multiple from
>This sample fist filters on all Customers in Washington, then uses a nested projection to flatten the customer orders, then filtering on all orders greater than the cut-off date
```csharp
//c#
static void Linq18()
{
    var customers = GetCustomerList();

    var orders = customers
        .Where(c => c.Region == "WA")
        .SelectMany(customer => customer.Orders, (customer, order) => new { customer, order })
        .Where(x => x.order.OrderDate >= cutoffDate)
        .Select(x => 
            new
            {
                x.customer.CustomerID, 
                x.customer.Region, 
                x.order.OrderID
            });

    ObjectDumper.Write(orders);
}
```
```java
//java
public static void Linq18() {
    List<Customer> customers = Data.getCustomerList();
        var cutoffDate = new GregorianCalendar(1997, 1, 1).getTime();
        customers.stream()
                .filter(c -> c.orders != null)
                .filter(c -> Objects.equals(c.region, "WA"))
                .flatMap(c -> c.orders.stream().map(o -> new Object(){
                    final Customer customer = c;
                    final Order order = o;
                }))
                .filter(o -> o.order.orderDate.compareTo(cutoffDate) >= 0 )
                .map(o -> new Object(){
                    final String customerID = o.customer.customerId;
                    final Integer orderId = o.order.orderId;
                    final String region = o.customer.region;
                })
                .forEach(o -> System.out.println("{CustomerId: " + o.customerID +
                        ", OrderId: " + o.orderId +
                        ", Region: " + o.region));
}
```
#### Output

    (customer_id='ALFKI', orderDate=datetime.datetime(1998, 1, 15, 0, 0), order_id=10835)
    (customer_id='ALFKI', orderDate=datetime.datetime(1998, 3, 16, 0, 0), order_id=10952)
    (customer_id='ALFKI', orderDate=datetime.datetime(1998, 4, 9, 0, 0), order_id=11011)
    (customer_id='ANATR', orderDate=datetime.datetime(1998, 3, 4, 0, 0), order_id=10926)
    (customer_id='ANTON', orderDate=datetime.datetime(1998, 1, 28, 0, 0), order_id=10856)
    ...

### linq19: SelectMany - Indexed
```csharp
//c#
public void Linq19() 
{ 
    var customers = GetCustomerList();

    var customerOrders =
            customers.SelectMany(
                (cust, custIndex) =>
                    cust.Orders.Select(o => $"Customer #{custIndex + 1}) has an order with OrderID {o.OrderID}"));

    ObjectDumper.Write(customerOrders);
}
```
```java
//java
public static void Linq19() {
    var customers = new ArrayList<>(Data.getCustomerList());
    IntStream.range(0, customers.size())
            .filter(i -> customers.get(i).orders != null)
            .mapToObj(i -> customers.get(i).orders.stream()
                        .map(o -> new Object(){
                                final int index = i +1;
                                final Integer orderID = o.orderId;
            }))
            .flatMap(s -> s)
            .forEach(o -> System.out.println("Customer " + o.index +
                                                " has an order with OrderID " + o.orderID));
}
```
#### Output

    Customer #1 has an order with OrderID 10643
    Customer #1 has an order with OrderID 10692
    Customer #1 has an order with OrderID 10702
    Customer #1 has an order with OrderID 10835
    Customer #1 has an order with OrderID 10952
    Customer #1 has an order with OrderID 11011
    Customer #2 has an order with OrderID 10308
    Customer #2 has an order with OrderID 10625
    Customer #2 has an order with OrderID 10759
    Customer #2 has an order with OrderID 10926
    ...

LINQ - Partitioning Operators
-----------------------------

### linq20: Take - Simple
>This sample uses a partition/slice to get only the first 3 elements of the array.
```csharp
//c#
static void Linq20()
{
    var numbers = new [] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var first3Numbers = numbers.Take(3);

    Console.WriteLine("First 3 numbers:");
    first3Numbers.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq20() {
    var numbers = new int[]{5, 4, 1, 3, 9, 8, 6, 7, 2, 0};

    var first3Numbers = Arrays.stream(numbers)
            .limit(3);

    print("First 3 numbers:");
    first3Numbers.forEach(System.out::println);
}
```
#### Output

    First 3 numbers:
    5
    4
    1

### linq21: Take - Nested
>This sample uses a partition/slice to get the first 3 orders from customers in Washington.
```csharp
//c#
static void Linq21()
{
    var customers = GetCustomerList();

    var first3WAOrders = customers
        .Where(c => c.Region == "WA")
        .SelectMany(customer => customer.Orders, (customer, order) => new { customer, order })
        .Select(x => 
            new
            {
                x.customer.CustomerID, 
                x.order.OrderID, 
                x.order.OrderDate
            })
        .Take(3);

    Console.WriteLine("First 3 orders in WA:");
    first3WAOrders.ForEach(ObjectDumper.Write);
}
```
```java
//java
public static void Linq21() {
    print("TODO");
}
```
#### Output

    First 3 orders in WA:
    (customer_id='LAZYK', orderDate=datetime.datetime(1997, 3, 21, 0, 0), order_id=10482)
    (customer_id='LAZYK', orderDate=datetime.datetime(1997, 5, 22, 0, 0), order_id=10545)
    (customer_id='TRAIH', orderDate=datetime.datetime(1997, 6, 19, 0, 0), order_id=10574)


### linq22: Skip - Simple
>This sample uses a partition to get all but the first four elements of the array.
```csharp
//c#
static void Linq22()
{
    var numbers = new []{ 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var allButFirst4Numbers = numbers.Skip(4);

    Console.WriteLine("All but first 4 numbers:");
    allButFirst4Numbers.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq22() {
    print("TODO");
}
```
#### Output

    All but first 4 numbers:
    9
    8
    6
    7
    2
    0

### linq23: Skip - Nested
>This sample uses Take to get all but the first 2 orders from customers in Washington.
```csharp
//c#
static void Linq23()
{
    var customers = GetCustomerList();

    var waOrders = customers
        .Where(c => c.Region == "WA")
        .SelectMany(customer => customer.Orders, (customer, order) => new { customer, order })
        .Select(x => 
            new
            {
                x.customer.CustomerID, 
                x.order.OrderID, 
                x.order.OrderDate
            });

    var allButFirst2Orders = waOrders.Skip(2);

    Console.WriteLine("All but first 2 orders in WA:");
    ObjectDumper.Write(allButFirst2Orders);
}
```
```java
//java
public static void Linq23() {
    print("TODO");
}
```
#### Output

    All but first 2 orders in WA:
    (customer_id='TRAIH', orderDate=datetime.datetime(1997, 6, 19, 0, 0), order_id=10574)
    (customer_id='TRAIH', orderDate=datetime.datetime(1997, 6, 23, 0, 0), order_id=10577)
    (customer_id='TRAIH', orderDate=datetime.datetime(1998, 1, 8, 0, 0), order_id=10822)
    (customer_id='WHITC', orderDate=datetime.datetime(1996, 7, 31, 0, 0), order_id=10269)
    (customer_id='WHITC', orderDate=datetime.datetime(1996, 11, 1, 0, 0), order_id=10344)
    (customer_id='WHITC', orderDate=datetime.datetime(1997, 3, 10, 0, 0), order_id=10469)
    (customer_id='WHITC', orderDate=datetime.datetime(1997, 3, 24, 0, 0), order_id=10483)
    (customer_id='WHITC', orderDate=datetime.datetime(1997, 4, 11, 0, 0), order_id=10504)
    (customer_id='WHITC', orderDate=datetime.datetime(1997, 7, 11, 0, 0), order_id=10596)
    (customer_id='WHITC', orderDate=datetime.datetime(1997, 10, 6, 0, 0), order_id=10693)
    (customer_id='WHITC', orderDate=datetime.datetime(1997, 10, 8, 0, 0), order_id=10696)
    (customer_id='WHITC', orderDate=datetime.datetime(1997, 10, 30, 0, 0), order_id=10723)
    (customer_id='WHITC', orderDate=datetime.datetime(1997, 11, 13, 0, 0), order_id=10740)
    (customer_id='WHITC', orderDate=datetime.datetime(1998, 1, 30, 0, 0), order_id=10861)
    (customer_id='WHITC', orderDate=datetime.datetime(1998, 2, 24, 0, 0), order_id=10904)
    (customer_id='WHITC', orderDate=datetime.datetime(1998, 4, 17, 0, 0), order_id=11032)
    (customer_id='WHITC', orderDate=datetime.datetime(1998, 5, 1, 0, 0), order_id=11066)


### linq24: TakeWhile - Simple
>This sample uses a partition to return elements starting from the beginning of the array until a number is read whose value is not less than 6.
```csharp
//c#
static void Linq24()
{
    var numbers = new[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var firstNumbersLessThan6 = numbers.TakeWhile(n => n < 6);

    Console.WriteLine("First numbers less than 6:");
    firstNumbersLessThan6.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq24() {
    var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var firstNumbersLessThan6 = Arrays.stream(numbers)
            .boxed()
            .takeWhile(n -> n < 6);

    print("First numbers less than 6:");
    firstNumbersLessThan6.forEach(System.out::println);
}
```
#### Output

    First numbers less than 6:
    5
    4
    1
    3

### linq25: TakeWhile - Indexed
>This sample uses a partition to return elements starting from the beginning of the array until a number is hit that is less than its position in the array.
```csharp
//c#
static void Linq25()
{
    var numbers = new [] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var firstSmallNumbers = numbers.TakeWhile((n, index) => n >= index);

    Console.WriteLine("First numbers not less than their position:");
    firstSmallNumbers.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq25() {
    var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var firstSmallNumbers = IntStream.range(0, numbers.length)
            .mapToObj(index -> new Object() {
                int Num = numbers[index];
                int Index = index;
            }).takeWhile(x -> x.Num >= x.Index);

    print("First numbers not less than their position:");
    firstSmallNumbers.forEach(x ->  print("%d" , x.Num));
}
```
#### Output

    First numbers not less than their position:
    5
    4

### linq26: SkipWhile - Simple
>This sample uses a partition to get the elements of the array starting from the first element divisible by 3.
```csharp
//c#
static void Linq26()
{
    var numbers = new [] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var allButFirst3Numbers = numbers.SkipWhile(n => n % 3 != 0);

    Console.WriteLine("All elements starting from first element divisible by 3:");
    allButFirst3Numbers.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq26() {
    var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var allButFirst3Numbers = Arrays.stream(numbers)
            .boxed()
            .dropWhile(n -> n % 3 != 0);

    print("All elements starting from first element divisible by 3:");
    allButFirst3Numbers.forEach(System.out::println);
}
```
#### Output

    All elements starting from first element divisible by 3:
    3
    9
    8
    6
    7
    2
    0

### linq27: SkipWhile - Indexed
>This sample uses a partition to get the elements of the array starting from the first element less than its position.
```csharp
//c#
static void Linq27()
{
    var numbers = new [] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var laterNumbers = numbers.SkipWhile((n, index) => n >= index);

    Console.WriteLine("All elements starting from first element less than its position:");
    laterNumbers.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq27() {
    var numbers = new int[]{5, 4, 1, 3, 9, 8, 6, 7, 2, 0};

    var firstSmallNumbers = IntStream.range(0, numbers.length)
            .mapToObj(index -> new Object() {
                int Num = numbers[index];
                int Index = index;
            }).dropWhile(x -> x.Num >= x.Index);

    print("First numbers not less than their position:");
    firstSmallNumbers.forEach(x -> print("%d", x.Num));
}
```
#### Output

    All elements starting from first element less than its position:
    1
    3
    9
    8
    6
    7
    2
    0


LINQ - Ordering Operators
-------------------------

### linq28: OrderBy - Simple 1
>This sample uses ordering to sort a list of words alphabetically.
```csharp
//c#
static void Linq28()
{
    var words = new [] { "cherry", "apple", "blueberry" };

    var sortedWords = words.OrderBy(w => w);

    Console.WriteLine("The sorted list of words:");
    sortedWords.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq28() {
    var words = new String[] { "cherry", "apple", "blueberry" };

    var sortedWords = Arrays.stream(words).sorted();

    print("The sorted list of words:");
    sortedWords.forEach(System.out::println);
}
```
#### Output

    The sorted list of words:
    apple
    blueberry
    cherry

### linq29: OrderBy - Simple 2
>This sample uses ordering to sort a list of words by length.
```csharp
//c#
static void Linq29()
{
    var words = new [] { "cherry", "apple", "blueberry" };

    var sortedWords = words.OrderBy(w => w.Length);

    Console.WriteLine("The sorted list of words (by length):"); 
    sortedWords.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq29() {
    var words = new String[] { "cherry", "apple", "blueberry" };

    var sortedWords = Arrays.stream(words)
            .sorted(Comparator.comparing(s -> s.length()));

    print("The sorted list of words:");
    sortedWords.forEach(System.out::println);
}
```
#### Output

    The sorted list of words (by length):
    apple
    cherry
    blueberry

### linq30: OrderBy - Simple 3
>This sample uses ordering to sort a list of products by name.
```csharp
//c#
static void Linq30()
{
    var products = GetProductList();

    var sortedProducts = products.OrderBy(p => p.ProductName);

    ObjectDumper.Write(sortedProducts);
}
```
```java
//java
public static void Linq30() {
    var products = Data.getProductList();

    var sortedProducts = products.stream()
            .sorted(Comparator.comparing(p -> p.productName));

    sortedProducts.forEach(System.out::println);
}
```
#### Output

    {productId: 17, productName: Alice Mutton, category: Meat/Poultry, unitPrice: 39.0, unitsInStock: 0}
    {productId: 3, productName: Aniseed Syrup, category: Condiments, unitPrice: 10.0, unitsInStock: 13}
    {productId: 40, productName: Boston Crab Meat, category: Seafood, unitPrice: 18.4, unitsInStock: 123}
    {productId: 60, productName: Camembert Pierrot, category: Dairy Products, unitPrice: 34.0, unitsInStock: 19}
    {productId: 18, productName: Carnarvon Tigers, category: Seafood, unitPrice: 62.5, unitsInStock: 42}
    ...

### linq31: OrderBy - Comparer
>This sample uses case-insensitive ordering to sort the words in an array.
```csharp
//c#
static void Linq31()
{
    var words = new [] { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" }; 

    var sortedWords = words.OrderBy(a => a, StringComparer.CurrentCultureIgnoreCase); 

    ObjectDumper.Write(sortedWords); 
}
```
```java
//java
public static void Linq31() {
    var words = new String[] { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };

    var sortedWords = Arrays.stream(words).
            sorted(Comparator.comparing(String::toString, String.CASE_INSENSITIVE_ORDER));

    sortedWords.forEach(System.out::println);
}
```
#### Output

    AbAcUs
    aPPLE
    BlUeBeRrY
    bRaNcH
    cHeRry
    ClOvEr

### linq32: OrderByDescending - Simple 1
>This sample uses reverse ordering to sort a list of doubles from highest to lowest.
```csharp
//c#
static void Linq32()
{
    var doubles = new[]{ 1.7, 2.3, 1.9, 4.1, 2.9 };

    var sortedDoubles = doubles.OrderByDescending(d => d);

    Console.WriteLine("The doubles from highest to lowest:");
    sortedDoubles.ForEach(Console.WriteLine);
}
```
```java
//java
public  static void Linq32() {
    var doubles = new Double[]{ 1.7, 2.3, 1.9, 4.1, 2.9 };

    var sortedDoubles = Arrays.stream(doubles)
            .sorted(Comparator.reverseOrder());

    print("The doubles from highest to lowest:");
    sortedDoubles.forEach((System.out::println));
}
```
#### Output

    The doubles from highest to lowest:
    4.1
    2.9
    2.3
    1.9
    1.7

### linq33: OrderByDescending - Simple 2
>This sample uses reverse ordering to sort a list of products by units in stock from highest to lowest.
```csharp
//c#
static void Linq33()
{
    var products = GetProductList();

    var sortedProducts = products.OrderByDescending(p => p.UnitsInStock);

    ObjectDumper.Write(sortedProducts);
}
```
```java
//java
public static void Linq33() {
    var products = Data.getProductList();

    var reverseSortedProducts = products.stream()
            .sorted(Comparator.comparing(Product::getUnitsInStock, Comparator.reverseOrder()));

    reverseSortedProducts.forEach(System.out::println);
}
```
#### Output

    {productId: 75, productName: Rh�nbr�u Klosterbier, category: Beverages, unitPrice: 7.75, unitsInStock: 125}
    {productId: 40, productName: Boston Crab Meat, category: Seafood, unitPrice: 18.4, unitsInStock: 123}
    {productId: 6, productName: Grandma's Boysenberry Spread, category: Condiments, unitPrice: 25.0, unitsInStock: 120}
    {productId: 55, productName: P�t� chinois, category: Meat/Poultry, unitPrice: 24.0, unitsInStock: 115}
    {productId: 61, productName: Sirop d'�rable, category: Condiments, unitPrice: 28.5, unitsInStock: 113}
    ...

### linq34: OrderByDescending - Comparer
>This sample uses reverse case-insensitive ordering to sort the words in an array.
```csharp
//c#
static void Linq34()
{
    var words = new [] { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };

    var sortedWords = words.OrderByDescending(a => a, StringComparer.CurrentCultureIgnoreCase); 

    ObjectDumper.Write(sortedWords);
}
```
```java
//java
public static void Linq34() {
    var words = new String[] { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };

    var sortedWords = Arrays.stream(words).
            sorted(Comparator.comparing(String::toString, String.CASE_INSENSITIVE_ORDER).reversed());

    sortedWords.forEach(System.out::println);
}
```
#### Output

    ClOvEr
    cHeRry
    bRaNcH
    BlUeBeRrY
    aPPLE
    AbAcUs

### linq35: ThenBy - Simple
>This sample uses nested ordering, first by length of their name, and then alphabetically by the name itself.
```csharp
//c#
static void Linq35()
{
    var digits = new [] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var sortedDigits = digits
        .OrderBy(d => d.Length)
        .ThenBy(d => d);

    Console.WriteLine("Sorted digits:");
    sortedDigits.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq35() {
public static void Linq35() {
    var digits = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var sortedDigits = Arrays.stream(digits)
            .sorted(
                    Comparator
                        .comparing(String::length)
                        .thenComparing(String::toString)
            );

    print("Sorted digits:");
    sortedDigits.forEach(System.out::println);
}
```
#### Output

    Sorted digits:
    one
    six
    two
    five
    four
    nine
    zero
    eight
    seven
    three

### linq36: ThenBy - Comparer
>This sample uses case-insensitive nested ordering, with a custom comparer to sort first by word length and then by a case-insensitive sort of the words in an array.
```csharp
//c#
static void Linq36()
{
    var words = new [] { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };

    var sortedWords = words
        .OrderBy(a => a.Length)
        .ThenBy(a => a, StringComparer.CurrentCultureIgnoreCase);

    ObjectDumper.Write(sortedWords);
}
```
```java
//java
public static void Linq36() {
    var words = new String[] { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };

    var sortedWords = Arrays.stream(words)
            .sorted(Comparator
                        .comparing(String::length)
                        .thenComparing(String::toString, String.CASE_INSENSITIVE_ORDER));

    sortedWords.forEach(System.out::println);
}
```
#### Output

    aPPLE
    AbAcUs
    bRaNcH
    cHeRry
    ClOvEr
    BlUeBeRrY

### linq37: ThenByDescending - Simple
>This sample uses nested ordering to sort a list of products, first by category, and then by unit price, from highest to lowest.
```csharp
//c#
public void Linq37() 
{ 
    List<Product> products = GetProductList(); 

    var sortedProducts = products
        .OrderBy(p => p.Category)
        .ThenByDescending(p => p.UnitPrice);

    ObjectDumper.Write(sortedProducts); 
}
```
```java
//java
public static void Linq37() {
    var products = Data.getProductList();

    var sortedProducts = products.stream()
            .sorted(Comparator
                        .comparing(Product::getCategory)
                        .thenComparing(Product::getUnitPrice, Comparator.reverseOrder()));

    sortedProducts.forEach(System.out::println);
}
```
#### Output

    {productId: 38, productName: C�te de Blaye, category: Beverages, unitPrice: 263.5, unitsInStock: 17}
    {productId: 43, productName: Ipoh Coffee, category: Beverages, unitPrice: 46.0, unitsInStock: 17}
    {productId: 2, productName: Chang, category: Beverages, unitPrice: 19.0, unitsInStock: 17}
    {productId: 76, productName: Lakkalik��ri, category: Beverages, unitPrice: 18.0, unitsInStock: 57}
    {productId: 39, productName: Chartreuse verte, category: Beverages, unitPrice: 18.0, unitsInStock: 69}
    {productId: 1, productName: Chai, category: Beverages, unitPrice: 18.0, unitsInStock: 39}
    {productId: 35, productName: Steeleye Stout, category: Beverages, unitPrice: 18.0, unitsInStock: 20}
    {productId: 70, productName: Outback Lager, category: Beverages, unitPrice: 15.0, unitsInStock: 15}
    {productId: 34, productName: Sasquatch Ale, category: Beverages, unitPrice: 14.0, unitsInStock: 111}
    ...

### linq38: ThenByDescending - Comparer
>This sample uses uses case-insensitive reverse nested ordering to sort first by word length and then by a case-insensitive descending sort of the words in an array.
```csharp
//c#
static void Linq38()
{
    var words = new [] { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };

    var sortedWords = words
        .OrderBy(a => a.Length)
        .ThenByDescending(a => a, StringComparer.CurrentCultureIgnoreCase);

    ObjectDumper.Write(sortedWords);
}
```
```java
//java
public static void Linq38() {
    var words = new String[] { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };

    var sortedWords = Arrays.stream(words)
            .sorted(Comparator
                    .comparing(String::length)
                    .thenComparing(String::toString, String.CASE_INSENSITIVE_ORDER.reversed()));

    sortedWords.forEach(System.out::println);
}
```
#### Output

    aPPLE
    ClOvEr
    cHeRry
    bRaNcH
    AbAcUs
    BlUeBeRrY

### linq39: Reverse
>This sample uses reverse ordering to create a list of all digits in the array whose second letter is 'i' that is reversed from the order in the original array.
```csharp
//c#
static void Linq39()
{
    var digits = new [] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var reversedIDigits = digits
        .Where(d => d[1] == 'i')
        .Reverse();

    Console.WriteLine("A backwards list of the digits with a second character of 'i':");
    reversedIDigits.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq39() {
    var digits = new String [] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var reversedIDigits = Arrays.stream(digits)
            .filter(s -> s.charAt(1) == 'i')
            .collect(Collectors.toCollection(LinkedList::new))
            .descendingIterator();

    print("A backwards list of the digits with a second character of 'i':");
    reversedIDigits.forEachRemaining(System.out::println);
}
```
#### Output

    A backwards list of the digits with a second character of 'i':
    nine
    eight
    six
    five


LINQ - Grouping Operators
-------------------------

### linq40: GroupBy - Simple 1
>This sample uses grouping to partition a list of numbers by their remainder when divided by 5.
```csharp
//c#
static void Linq40()
{
    var numbers = new[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 }; 

    var numberGroups = numbers
        .GroupBy(n => n % 5)
        .Select(x => 
            new
            {
                Remainder = x.Key, 
                Numbers = x
            });

    numberGroups.ForEach((g) => 
    {
            Console.WriteLine("Numbers with a remainder of {0} when divided by 5:", g.Remainder);
            g.Numbers.ForEach(Console.WriteLine);
    });
}
```
```java
//java
public static void Linq40() {
    var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var numberGroups = Arrays.stream(numbers).boxed()
            .collect(Collectors.groupingBy(n -> n % 5, Collectors.toList()));

    for (var key:numberGroups.keySet()) {
        print("Numbers with a remainder of %d when divided by 5:", key);
        numberGroups.get(key).forEach(System.out::println);
    }
}
```
#### Output

    Numbers with a remainder of 0 when divided by 5:
    5
    0
    Numbers with a remainder of 1 when divided by 5:
    1
    6
    Numbers with a remainder of 2 when divided by 5:
    7
    2
    Numbers with a remainder of 3 when divided by 5:
    3
    8
    Numbers with a remainder of 4 when divided by 5:
    4
    9

### linq41: GroupBy - Simple 2
>This sample uses grouping to partition a list of words by their first letter.
```csharp
//c#
static void Linq41()
{
    var words = new [] { "blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese" }; 

    var wordGroups = words
        .GroupBy(w => w[0])
        .Select(g => 
            new
            {
                FirstLetter = g.Key, 
                Words = g
            });

    wordGroups.ForEach((g) => 
    {
        Console.WriteLine($"Words that start with the letter '{g.FirstLetter}':");
        g.Words.ForEach(Console.WriteLine);
    });
}
```
```java
//java
public static void Linq41() {
    var words = new String [] { "blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese" };

    var wordGroups = Arrays.stream(words)
            .collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.toList()));

    for (var key:wordGroups.keySet()) {
        print("Words that start with the letter '%s':", key);
        wordGroups.get(key).forEach(System.out::println);
    }
}
```
#### Output

    Words that start with the letter 'a':
    abacus
    apple
    Words that start with the letter 'b':
    banana
    blueberry
    Words that start with the letter 'c':
    cheese
    chimpanzee

### linq42: GroupBy - Simple 3
>This sample uses grouping to partition a list of products by category.
```csharp
//c#
static void Linq42()
{
    var products = GetProductList(); 
    
    var orderGroups = products
        .GroupBy(p => p.Category)
        .Select(g => 
            new
            {
                Category = g.Key, 
                Products = g
            }); 

    ObjectDumper.Write(orderGroups, 1); 
}
```
```java
//java
public static void Linq42() {
    var products = Data.getProductList();

    var productCategories = products.stream()
            .collect(Collectors.groupingBy(p -> p.category, Collectors.toList()));

    for (var key:productCategories.keySet()) {
        print("Products in the category '%s':" , key);
        productCategories.get(key).forEach(System.out::println);
    }
}
```
#### Output

    Products in the category 'Grains/Cereals':
    (Product id=22, name=Gustaf's Knäckebröd, cat=Grains/Cereals, price=21.0, inStock=104)
    (Product id=23, name=Tunnbröd, cat=Grains/Cereals, price=9.0, inStock=61)
    (Product id=42, name=Singaporean Hokkien Fried Mee, cat=Grains/Cereals, price=14.0, inStock=26)
    (Product id=52, name=Filo Mix, cat=Grains/Cereals, price=7.0, inStock=38)
    (Product id=56, name=Gnocchi di nonna Alice, cat=Grains/Cereals, price=38.0, inStock=21)
    (Product id=57, name=Ravioli Angelo, cat=Grains/Cereals, price=19.5, inStock=36)
    (Product id=64, name=Wimmers gute Semmelknödel, cat=Grains/Cereals, price=33.25, inStock=22)
    Products in the category 'Confections':
    (Product id=16, name=Pavlova, cat=Confections, price=17.45, inStock=29)
    (Product id=19, name=Teatime Chocolate Biscuits, cat=Confections, price=9.2, inStock=25)
    ...

### linq43: GroupBy - Nested
>This sample uses nested grouping to partition a list of each customer's orders, first by year, and then by month.
```csharp
//c#
public void Linq43() 
{ 
    var customers = GetCustomerList(); 

    var customerOrderGroups = customers
        .Select(c => new 
        {
            c.CompanyName,
            YearGroups = 
            (
                c.Orders
                    .GroupBy(y => y.OrderDate.Year)
                    .Select(YearGroup => new 
                    {
                        Year = YearGroup.Key,
                        MonthGroups = 
                        (
                            YearGroup
                            .GroupBy(m =>  m.OrderDate.Month)
                            .Select(MonthGroup => new
                            {
                                Month = MonthGroup.Key, Orders = MonthGroup
                            })

                        )
                    })
            )
        });
        
    ObjectDumper.Write(customerOrderGroups, 3); 
} 
```
```java
//java
public  static void Linq43() {
    print("TODO");
}
```
#### Output

    {CompanyName: Alfreds Futterkiste, YearGroups: {{Year: 1997, MonthGroups: {{Month: 8, Orders: {{orderId: 10643, orderDate: 1997-08-25 00:00:00.000, total: 814.5}}}, {Month: 10, Orders: {{orderId: 10692, orderDate: 1997-10-03 00:00:00.000, total: 878.0}, {orderId: 10702, orderDate: 1997-10-13 00:00:00.000, total: 330.0}}}}}, {Year: 1998, MonthGroups: {{Month: 1, Orders: {{orderId: 10835, orderDate: 1998-01-15 00:00:00.000, total: 845.8}}}, {Month: 3, Orders: {{orderId: 10952, orderDate: 1998-03-16 00:00:00.000, total: 471.2}}}, {Month: 4, Orders: {{orderId: 11011, orderDate: 1998-04-09 00:00:00.000, total: 933.5}}}}}}}
    {CompanyName: Ana Trujillo Emparedados y helados, YearGroups: {{Year: 1996, MonthGroups: {{Month: 9, Orders: {{orderId: 10308, orderDate: 1996-09-18 00:00:00.000, total: 88.8}}}}}, {Year: 1997, MonthGroups: {{Month: 8, Orders: {{orderId: 10625, orderDate: 1997-08-08 00:00:00.000, total: 479.75}}}, {Month: 11, Orders: {{orderId: 10759, orderDate: 1997-11-28 00:00:00.000, total: 320.0}}}}}, {Year: 1998, MonthGroups: {{Month: 3, Orders: {{orderId: 10926, orderDate: 1998-03-04 00:00:00.000, total: 514.4}}}}}}}


LINQ - Set Operators
--------------------

### linq46: Distinct - 1
>This sample removes all duplicate elements in a sequence of factors of 300.
```csharp
//c#
static void Linq46()
{
    int[] factorsOf300 = { 2, 2, 3, 5, 5 };

    var uniqueFactors = factorsOf300.Distinct();

    Console.WriteLine("Prime factors of 300:");
    uniqueFactors.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq46() {
    int[] factorsOf300 = { 2, 2, 3, 5, 5 };

    var uniqueFactors = Arrays.stream(factorsOf300).boxed()
            .distinct();

    print("Prime factors of 300:");
    uniqueFactors.forEach(System.out::println);
}
```
#### Output

    Prime factors of 300:
    2
    3
    5

### linq47: Distinct - 2
>This sample gets distint Category names from all the products.
```csharp
//c#
static void Linq47()
{
    var products = GetProductList();

    var categoryNames = products
        .Select(p => p.Category)
        .Distinct();

    Console.WriteLine("Category names:");
    categoryNames.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq47() {
    var products = Data.getProductList();

    var productCategories = products.stream()
            .map(p -> p.category)
            .distinct();

    print("Category names:");
    productCategories.forEach(System.out::println);
}
```
#### Output

    Category names:
    Beverages
    Dairy Products
    Condiments
    Meat/Poultry
    Produce
    Seafood
    Grains/Cereals
    Confections

### linq48: Union - 1
>This sample creates a Union of sequences that contains unique values from both arrays.
```csharp
//c#
static void Linq48()
{
    int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
    int[] numbersB = { 1, 3, 5, 7, 8 };

    var uniqueNumbers = numbersA.Union(numbersB);

    Console.WriteLine("Unique numbers from both arrays:");
    uniqueNumbers.ForEach(Console.WriteLine);
}  
```
```java
//java
public static void Linq48() {
    int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
    int[] numbersB = { 1, 3, 5, 7, 8 };

    var uniqueNumbers = Stream
            .concat(
                    Arrays.stream(numbersA).boxed(),
                    Arrays.stream(numbersB).boxed())
            .distinct();

    print("Unique numbers from both arrays:");
    uniqueNumbers.forEach(System.out::println);
}
```
#### Output

    Unique numbers from both arrays:
    0
    1
    2
    3
    4
    5
    6
    7
    8
    9

### linq49: Union - 2
>This sample creates a Union of sequences that contains the distinct first letter from both product and customer names
```csharp
//c#
static void Linq49()
{
    var products = GetProductList();
    var customers = GetCustomerList();

    var productFirstChars = products.Select(p => p.ProductName[0]);
    var customerFirstChars = customers.Select(c => c.CompanyName[0]);

    var uniqueFirstChars = productFirstChars.Union(customerFirstChars);

    Console.WriteLine("Unique first letters from Product names and Customer names:");
    uniqueFirstChars.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq49() {
    var products = Data.getProductList();
    var customers = Data.getCustomerList();

    var productChars = products.stream().map(p -> p.productName.charAt(0));
    var customerChars = customers.stream().map(c -> c.companyName.charAt(0));

    var uniqueFirstChars = Stream
            .concat(productChars, customerChars)
            .distinct();

    print("Unique first letters from Product names and Customer names:");
    uniqueFirstChars.forEach(System.out::println);
}
```
#### Output

    Unique first letters from Product names and Customer names:
    G
    W
    R
    I
    P
    Z
    L
    U
    C
    O
    N
    F
    A
    D
    T
    E
    J
    K
    S
    Q
    H
    M
    B
    V

### linq50: Intersect - 1
>This sample creates Intersection that contains the common values shared by both arrays.
```csharp
//c#
static void Linq50()
{
    int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
    int[] numbersB = { 1, 3, 5, 7, 8 };

    var commonNumbers = numbersA.Intersect(numbersB);

    Console.WriteLine("Common numbers shared by both arrays:");
    commonNumbers.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq50() {
    int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
    int[] numbersB = { 1, 3, 5, 7, 8 };

        var uniqueNumbers = Arrays.stream(numbersA)
                .filter(a -> Arrays.stream(numbersB).anyMatch(b -> b == a));

        print("Common numbers shared by both arrays:");
    uniqueNumbers.forEach(System.out::println);
}
```
#### Output

    Common numbers shared by both arrays:
    8
    5

### linq51: Intersect - 2
>This sample creates Intersection that contains contains the common first letter from both product and customer names.
```csharp
//c#
static void Linq51()
{
    var products = GetProductList();
    var customers = GetCustomerList();

    var productFirstChars = products.Select(p => p.ProductName[0]);
    var customerFirstChars = customers.Select(c => c.CompanyName[0]);

    var commonFirstChars = productFirstChars.Intersect(customerFirstChars);

    Console.WriteLine("Common first letters from Product names and Customer names:");
    commonFirstChars.ForEach(Console.WriteLine);
} 
```
```java
//java
public static void Linq51() {
    var products = Data.getProductList();
    var customers = Data.getCustomerList();

    var uniqueFirstChars = products.stream()
            .map(p -> p.productName.charAt(0))
            .filter(p -> customers.stream().map(c -> c.companyName.charAt(0)).anyMatch(c -> c == p))
            .distinct();

    print("Common first letters from Product names and Customer names:");
    uniqueFirstChars.forEach(System.out::println);
}
```
#### Output

    Common first letters from Product names and Customer names:
    C
    A
    G
    N
    M
    I
    Q
    K
    T
    P
    S
    R
    B
    V
    F
    E
    W
    L
    O

### linq52: Except - 1
>This sample creates a sequence that excludes the values from the second sequence.
```csharp
//c#
public static void Linq52() {
    int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
    int[] numbersB = { 1, 3, 5, 7, 8 };

    var uniqueNumbers = Arrays.stream(numbersA)
            .filter(a -> Arrays.stream(numbersB).noneMatch(b -> b == a));

    print("Common numbers shared by both arrays:");
    uniqueNumbers.forEach(System.out::println);
}
```
```java
//java
public static void Linq52() {
    int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
    int[] numbersB = { 1, 3, 5, 7, 8 };

    var uniqueNumbers = Arrays.stream(numbersA)
            .filter(a -> Arrays.stream(numbersB).noneMatch(b -> b == a));

    print("Common numbers shared by both arrays:");
    uniqueNumbers.forEach(System.out::println);
}
```
#### Output

    Numbers in first array but not second array:
    0
    2
    4
    6
    9

### linq53: Except - 2
>This sample creates a sequence that the first letters of product names that but excludes letters of customer names first letter.
```csharp
//c#
static void Linq53()
{
    var products = GetProductList();
    var customers = GetCustomerList();

    var productFirstChars = products.Select(p => p.ProductName[0]);
    var customerFirstChars = customers.Select(c => c.CompanyName[0]);

    var productOnlyFirstChars = productFirstChars.Except(customerFirstChars);

    Console.WriteLine("First letters from Product names, but not from Customer names:");
    productOnlyFirstChars.ForEach(Console.WriteLine);
}   
```
```java
//java
public static void Linq53() {
    var products = Data.getProductList();
    var customers = Data.getCustomerList();

    var uniqueFirstChars = products.stream()
            .map(p -> p.productName.charAt(0))
            .filter(p -> customers.stream().map(c -> c.companyName.charAt(0)).noneMatch(c -> c == p))
            .distinct();

    print("Common first letters from Product names and Customer names:");
    uniqueFirstChars.forEach(System.out::println);
}
```
#### Output

    First letters from Product names, but not from Customer names:
    U
    J
    Z


LINQ - Conversion Operators
---------------------------

### linq54: ToArray
>This sample converts a list ti an array.
```csharp
//c#
static void Linq54()
{
    var list = new List<double> { 1.7, 2.3, 1.9, 4.1, 2.9 };

    var doublesArray = list
        .OrderByDescending(d => d)
        .ToArray();
        
    Console.WriteLine("Every other double from highest to lowest:");
    for (var d = 0; d < doublesArray.Length; d += 2)
    {
        Console.WriteLine(doublesArray[d]);
    }
}
```
```java
//java
public static void Linq54() {
    var list = new double[] { 1.7, 2.3, 1.9, 4.1, 2.9 };

    var sortedDoubles = Arrays.stream(list).boxed()
            .sorted(Comparator.reverseOrder())
            .toArray();

    print("Every other double from highest to lowest:");
    for (int i = 0; i < sortedDoubles.length - 1; i += 2) {
        System.out.println(sortedDoubles[i]);
    }
```
#### Output

    Every other double from highest to lowest:
    4.1
    2.3
    1.7

### linq55: ToList
>This sample converts an array to a list
```csharp
//c#
static void Linq55()
{
    var words = new[] { "cherry", "apple", "blueberry" };

    var wordList = words
        .OrderBy(x => x)
        .ToList();

    Console.WriteLine("The sorted word list:");
    wordList.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq55() {
    var words = new String[] { "cherry", "apple", "blueberry" };

    var wordList = Arrays.stream(words)
            .sorted()
            .collect(Collectors.toList());

    print("The sorted word list:");
    wordList.forEach(System.out::println);
}
```
#### Output

    The sorted word list:
    apple
    blueberry
    cherry

### linq56: ToDictionary
>This sample converts an array of records to a dictionary
```csharp
//c#
static void Linq56()
{
    var scoreRecords = 
        new[] 
        { 
            new {Name = "Alice", Score = 50},
            new {Name = "Bob"  , Score = 40},
            new {Name = "Cathy", Score = 45}
        };

    var scoreRecordsDict = scoreRecords.ToDictionary(sr => sr.Name);

    Console.WriteLine("Bob's score: {0}", scoreRecordsDict["Bob"]);
}
```
```java
//java
public static void Linq56() {

    class StudentScore {
        public String name;
        public int score;

        public StudentScore(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    var scoreRecords =new ArrayList<StudentScore>();
    scoreRecords.add(new StudentScore("Alice", 50));
    scoreRecords.add(new StudentScore("Bob", 40));
    scoreRecords.add(new StudentScore("Cathy", 45));

    var scoreRecordsMap= scoreRecords.stream()
            .collect(Collectors.toMap(s -> s.name, s -> s.score));

    print("Bob's score: %s", scoreRecordsMap.get("Bob"));
}
```
#### Output

    Bob's score: {Name: Bob, Score: 40}

### linq57: OfType
>This sample filters all elements that matches the type double/float.
```csharp
//c#
static void Linq57()
{
    var numbers = new object[]{ null, 1.0, "two", 3, "four", 5, "six", 7.0 };

    var doubles = numbers.OfType<double>();

    Console.WriteLine("Numbers stored as doubles:");
    doubles.ForEach(Console.WriteLine);
} 
```
```java
//java
public static void Linq57() {
    var numbers = new Object[]{ null, 1.0, "two", 3, "four", 5, "six", 7.0 };

    var doubles = Arrays.stream(numbers)
            .filter(Double.class::isInstance);

    doubles.forEach(System.out::println);
}
```
#### Output

    Numbers stored as doubles:
    1.0
    7.0


LINQ - Element Operators
------------------------

### linq58: First - Simple
>This sample returns the first matching element as a Product, instead of as a sequence containing a Product.
```csharp
//c#
static void Linq58()
{
    var products = GetProductList();

    var product12 = products.First(p => p.ProductID == 12);

    ObjectDumper.Write(product12);
}
```
```java
//java
public static void Linq58() {
    var products = Data.getProductList();

    var produdct12 = products.stream()
                        .filter(p -> p.productId == 12)
                        .findFirst();

    System.out.println(produdct12);
}
```
#### Output

    Optional[(Product id=12, name=Queso Manchego La Pastora, cat=Dairy Products, price=38.0, inStock=86)]

### linq59: First - Condition
>This sample finds the first element in the array that starts with 'o'.
```csharp
//c#
static void Linq59()
{
    var strings = new []{ "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var startsWithO = strings.First(s => s.StartsWith('o'));

    Console.WriteLine("A string starting with 'o': {0}", startsWithO);
}
```
```java
//java
public static void Linq59() {
    var strings = new String[]{ "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    var startsWithO = Arrays.stream(strings)
            .filter(s -> s.startsWith("o"))
            .findFirst();

    print("A string starting with 'o': %s", startsWithO);
}
```
#### Output

    A string starting with 'o': one

### linq61: FirstOrDefault - Simple
>This sample returns the first or default if nothing is found, to try to return the first element of the sequence unless there are no elements, in which case the default value for that type is returned.
```csharp
//c#
static void Linq61()
{
    var numbers = new int[0];

    var firstNumOrDefault = numbers.FirstOrDefault();

    Console.WriteLine(firstNumOrDefault);
}
```
```java
//java
public static void Linq61() {
    var numbers = new int[0];

    var firstNumOrdDefault = Arrays.stream(numbers).boxed()
            .findFirst()
            .orElse(0);

    System.out.println(firstNumOrdDefault);
}
```
#### Output

    0

### linq62: FirstOrDefault - Condition
>This sample returns the first or default if nothing is found, to return the first product whose ProductID is 789 as a single Product object, unless there is no match, in which case null is returned.
```csharp
//c#
static void Linq62()
{
    var products = GetProductList();

    var product789 = products.FirstOrDefault(p => p.ProductID == 789);

    Console.WriteLine("Product 789 exists: {0}", product789 != null);
}
```
```java
//java
public static void Linq62() {
    var products = Data.getProductList();

    var product789 = products.stream()
            .filter(p -> p.productId == 789)
            .findFirst()
            .orElse(null);

    print("Product 789 exists: %s" , product789 != null);
}
```
#### Output

    Product 789 exists: false

### linq64: ElementAt
>This sample retrieve the second number greater than 5 from an array.
```csharp
//c#
static void Linq64()
{
    var numbers = new [] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var fourthLowNum = numbers
        .Where(num => num > 5)
        .ElementAt(1);

    Console.WriteLine("Second number > 5: {0}", fourthLowNum);
}           
```
```java
//java
public static void Linq64() {
    var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var secondNumberGreaterThan5 = Arrays.stream(numbers).boxed()
            .filter(n -> n > 5)
            .toArray()
            [1];

    print("Second number > 5: %d" , secondNumberGreaterThan5);
}
```
#### Output

    Second number > 5: 8


LINQ - Generation Operators
---------------------------

### linq65: Range
>This sample uses generates a sequence of numbers from 100 to 149 that is used to find which numbers in that range are odd and even.
```csharp
//c#
static void Linq65()
{
    var numbers = Enumerable.Range(100, 50)
        .Select(n => 
            new
            {
                Number = n, 
                OddEven = n % 2 == 1 ? "odd" : "even"
            });

    numbers.ForEach((n) => Console.WriteLine("The number {0} is {1}.", n.Number, n.OddEven));
}
```
```java
//java
public static void Linq65() {
    var numbersEvenOdd = IntStream.range(100, 150)
            .mapToObj(n -> new Object() {
                int Number = n;
                String OddEven = (n % 2 == 0 ? "even" : "odd");
            })
            .collect(Collectors.toList());

    for (var num: numbersEvenOdd) {
        print("The number %d is %s", num.Number, num.OddEven);
    }
}
```
#### Output

    The number 100 is even.
    The number 101 is odd.
    The number 102 is even.
    The number 103 is odd.
    The number 104 is even.
    The number 105 is odd.
    The number 106 is even.
    The number 107 is odd.
    The number 108 is even.
    The number 109 is odd.
    The number 110 is even.
    ...

### linq66: Repeat
>This sample uses generates a sequence of repeated numbers that contains the number 7 ten times.
```csharp
//c#
static void Linq66()
{
    var numbers = Enumerable.Repeat(7, 10);

    numbers.ForEach(Console.WriteLine);
}  
```
```java
//java
public static void Linq66() {
    var numbers  = new int[10];

    Arrays.fill(numbers, 7);

    for (int number : numbers) {
        System.out.println(number);
    }
    }
```
#### Output

    7
    7
    7
    7
    7
    7
    7
    7
    7
    7


LINQ - Quantifiers
------------------

### linq67: Any - Simple
>This sample uses determines if Any of the words in the array contain the substring 'ei'.
```csharp
//c#
static void Linq67()
{
    var words = new []{ "believe", "relief", "receipt", "field" };

    var iAfterE = words.Any(w => w.Contains("ei"));

    Console.WriteLine($"There is a word in the list that contains 'ei': {iAfterE}");
}
```
```java
//java
public static void Linq67() {
    var words = new String []{ "believe", "relief", "receipt", "field" };

    var iAfterE = Arrays.stream(words)
            .anyMatch(w -> w.contains("ei"));

    print("There is a word that contains in the list that contains 'ei': %s",  iAfterE);
}
```
#### Output

    There is a word that contains in the list that contains 'ei': true

### linq69: Any - Grouped
>This sample determines if Any of the grouped a list of products only for categories that have at least one product that is out of stock.
```csharp
//c#
static void Linq69()
{
    var products = GetProductList();

    var productGroups = products
        .GroupBy(prod => prod.Category)
        .Where(prodGroup => prodGroup.Any(p => p.UnitsInStock == 0))
        .Select(prodGroup => 
            new
            {
                Category = prodGroup.Key, 
                Products = prodGroup
            });

    ObjectDumper.Write(productGroups, 1);
}
```
```java
//java
public static void Linq69() {
    print("TODO");
}
```
#### Output

    {Category: Condiments, Products: {{productId: 3, productName: Aniseed Syrup, category: Condiments, unitPrice: 10.0, unitsInStock: 13}, {productId: 4, productName: Chef Anton's Cajun Seasoning, category: Condiments, unitPrice: 22.0, unitsInStock: 53}, {productId: 5, productName: Chef Anton's Gumbo Mix, category: Condiments, unitPrice: 21.35, unitsInStock: 0}, {productId: 6, productName: Grandma's Boysenberry Spread, category: Condiments, unitPrice: 25.0, unitsInStock: 120}, {productId: 8, productName: Northwoods Cranberry Sauce, category: Condiments, unitPrice: 40.0, unitsInStock: 6}, {productId: 15, productName: Genen Shouyu, category: Condiments, unitPrice: 15.5, unitsInStock: 39}, {productId: 44, productName: Gula Malacca, category: Condiments, unitPrice: 19.45, unitsInStock: 27}, {productId: 61, productName: Sirop d'�rable, category: Condiments, unitPrice: 28.5, unitsInStock: 113}, {productId: 63, productName: Vegie-spread, category: Condiments, unitPrice: 43.9, unitsInStock: 24}, {productId: 65, productName: Louisiana Fiery Hot Pepper Sauce, category: Condiments, unitPrice: 21.05, unitsInStock: 76}, {productId: 66, productName: Louisiana Hot Spiced Okra, category: Condiments, unitPrice: 17.0, unitsInStock: 4}, {productId: 77, productName: Original Frankfurter gr�ne So�e, category: Condiments, unitPrice: 13.0, unitsInStock: 32}}}
    ...

### linq70: All - Simple
>This sample determines if All the elements in the array contain only odd numbers.
```csharp
//c#
static void Linq70()
{
    var numbers = new [] { 1, 11, 3, 19, 41, 65, 19 };

    var onlyOdd = numbers.All(n => n % 2 == 1);

    Console.WriteLine($"The list contains only odd numbers: {onlyOdd}");
}
```
```java
//java
public static void Linq70() {
    var numbers = new int[] { 1, 11, 3, 19, 41, 65, 19 };

    var onlyOdd = Arrays.stream(numbers)
            .allMatch(n -> n % 2 == 1);

    print("The list contains only odd numbers: %s",  onlyOdd);
}
```
#### Output

    The list contains only odd numbers: true

### linq72: All - Grouped
>This sample determines if All elements in the grouped a list of products by categories, have all of their products in stock.
```csharp
//c#
static void Linq72()
{
    var products = GetProductList();

    var productGroups = products
        .GroupBy(prod => prod.Category)
        .Where(prodGroup => prodGroup.All(p => p.UnitsInStock > 0))
        .Select(prodGroup => 
            new
            {
                Category = prodGroup.Key, 
                Products = prodGroup
            });

    ObjectDumper.Write(productGroups, 1);
}
```
```java
//java
public static void Linq71() {
    print("TODO");
}
```
#### Output

    {Category: Grains/Cereals, Products: {{productId: 22, productName: Gustaf's Kn�ckebr�d, category: Grains/Cereals, unitPrice: 21.0, unitsInStock: 104}, {productId: 23, productName: Tunnbr�d, category: Grains/Cereals, unitPrice: 9.0, unitsInStock: 61}, {productId: 42, productName: Singaporean Hokkien Fried Mee, category: Grains/Cereals, unitPrice: 14.0, unitsInStock: 26}, {productId: 52, productName: Filo Mix, category: Grains/Cereals, unitPrice: 7.0, unitsInStock: 38}, {productId: 56, productName: Gnocchi di nonna Alice, category: Grains/Cereals, unitPrice: 38.0, unitsInStock: 21}, {productId: 57, productName: Ravioli Angelo, category: Grains/Cereals, unitPrice: 19.5, unitsInStock: 36}, {productId: 64, productName: Wimmers gute Semmelkn�del, category: Grains/Cereals, unitPrice: 33.25, unitsInStock: 22}}}
    ...


LINQ - Aggregate Operators
--------------------------


### linq73: Count - Simple
>This sample gets the number of unique prime factors of 300.
```csharp
//c#
static void Linq73()
{
    var primeFactorsOf300 = new [] { 2, 2, 3, 5, 5 };

    var uniqueFactors = primeFactorsOf300.Distinct().Count();

    Console.WriteLine($"There are {uniqueFactors} unique prime factors of 300.");
}
```
```java
//java
public static void Linq73() {
    var primeFactorsOf300 = new int [] { 2, 2, 3, 5, 5 };

    var uniqueFactors = Arrays.stream(primeFactorsOf300).distinct().count();

    print("There are %d unique factors of 300.",  uniqueFactors);
}
```
#### Output

    There are 3 unique factors of 300.

### linq74: Count - Conditional
>This sample gets the number of odd ints in the array.
```csharp
//c#
static void Linq74()
{
    var numbers = new [] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var oddNumbers = numbers.Count(n => n % 2 == 1);

    Console.WriteLine($"There are {oddNumbers} odd numbers in the list.");
}
```
```java
//java
public static void Linq74() {
    var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var oddNumbers = Arrays.stream(numbers)
            .filter(n -> n % 2 == 1)
            .count();

    print("There are %d odd numbers in the list.", oddNumbers);
}
```
#### Output

    There are 5 odd numbers in the list.

### linq76: Count - Nested
>This sample uses returns a list of customers and how many orders each has.
```csharp
//c#
static void Linq76()
{
    var customers = GetCustomerList();

    var orderCounts = customers
        .Select(cust => 
            new
            {
                cust.CustomerID, 
                OrderCount = cust.Orders.Count()
            });

    ObjectDumper.Write(orderCounts);
}
```
```java
//java
public static void Linq75() {
    var customers = Data.getCustomerList();


    var orderCounts = customers.stream()
            .map(c -> new Object() {
                String customerId = c.customerId;
                int orderCount = c.orders != null ? c.orders.size() : 0;
            })
            .collect(Collectors.toList());

    for (var o : orderCounts) {
        print("{CustomerId: %s, OrderCount: %d}", o.customerId, o.orderCount);
    }
}
```
#### Output

    {CustomerId: ALFKI, OrderCount: 6}
    {CustomerId: ANATR, OrderCount: 4}
    {CustomerId: ANTON, OrderCount: 7}
    {CustomerId: AROUT, OrderCount: 13}
    {CustomerId: BERGS, OrderCount: 18}
    {CustomerId: BLAUS, OrderCount: 7}
    {CustomerId: BLONP, OrderCount: 11}
    ...

### linq77: Count - Grouped
>This sample uses returns a list of categories and how many products each has.
```csharp
//c#
static void Linq77()
{
    var products = GetProductList();

    var categoryCounts = products
        .GroupBy(prod => prod.Category)
        .Select(prodGroup => 
            new
            {
                Category = prodGroup.Key, 
                ProductCount = prodGroup.Count()
            });

    ObjectDumper.Write(categoryCounts);
}
```
```java
//java
public static void Linq77() {
    var products = Data.getProductList();

    var categoryCounts = products.stream()
            .collect(Collectors.groupingBy(p -> p.category,  Collectors.counting()));

    System.out.println((categoryCounts));
}
```
#### Output

    {Grains/Cereals=7, Confections=13, Produce=5, Meat/Poultry=6, Seafood=12, Beverages=12, Dairy Products=10, Condiments=12}

### linq78: Sum - Simple
>This sample uses adds all the numbers in an array.
```csharp
//c#
static void Linq78()
{
    var numbers = new [] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var numSum = numbers.Sum();

    Console.WriteLine($"The sum of the numbers is {numSum}.");
}
```
```java
//java
public static void Linq78() {
    var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var numSum = Arrays.stream(numbers).sum();

    print("The sum of the numbers is %d." , numSum);
}
```
#### Output

    The sum of the numbers is 45.

### linq79: Sum - Projection
>This sample  gets the total number of characters of all words in the array.
```csharp
//c#
static void Linq79()
{
    var  words = new [] { "cherry", "apple", "blueberry" };

    var totalChars = words.Sum(w => w.Length);

    Console.WriteLine($"There are a total of {totalChars} characters in these words.");
}
```
```java
//java
public static void Linq79() {
    var  words = new String[] { "cherry", "apple", "blueberry" };

    var totalChars = Arrays.stream(words)
            .mapToInt(w -> w.length())
            .sum();

    print("There are a total of %d characters in these words.", totalChars);
}
```
#### Output

    There are a total of 20 characters in these words.

### linq80: Sum - Grouped
>This sample gets the total units in stock for each product category.
```csharp
//c#
static void Linq80()
{
    var products = GetProductList();

    var categories = products
        .GroupBy(prod => prod.Category)
        .Select(prodGroup => 
            new
            {
                Category = prodGroup.Key, 
                TotalUnitsInStock = prodGroup.Sum(p => p.UnitsInStock)
            });

    ObjectDumper.Write(categories);
}
```
```java
//java
    public static void Linq80() {
        var products = Data.getProductList();

        var categoryStockCounts = products.stream()
                .collect(Collectors.groupingBy(p -> p.category,
                        Collectors.summingInt(p -> p.unitsInStock)));

        System.out.println((categoryStockCounts));
    }
```
#### Output

    {Grains/Cereals=308, Confections=386, Produce=100, Meat/Poultry=165, Seafood=701, Beverages=559, Dairy Products=393, Condiments=507}

### linq81: Min - Simple
>This sample uses gets the lowest number in an array.
```csharp
//c#
static void Linq81()
{
    var numbers = new []{ 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var minNum = numbers.Min();

    Console.WriteLine($"The minimum number is {minNum}.");
} 
```
```java
//java
public static void Linq81() {
    var numbers = new int[]{ 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var minNum = Arrays.stream(numbers).min().getAsInt();

    print("The minimum number is %d", minNum);
}
```
#### Output

    The minimum number is 0.

### linq82: Min - Projection
>This sample uses gets the length of the shortest word in an array.>
```csharp
//c#
static void Linq82()
{
    var words = new [] { "cherry", "apple", "blueberry" };

    var shortestWord = words.Min(w => w.Length);

    Console.WriteLine($"The shortest word is {shortestWord} characters long.");
}
```
```java
//java
public static void Linq82() {
    var words = new String[] { "cherry", "apple", "blueberry" };

    var shortestWord = Arrays.stream(words)
            .mapToInt(w -> w.length())
            .min()
            .getAsInt();

    print("The shortest word is %d characters long.", shortestWord);
}
```
#### Output

    The shortest word is 5 characters long.

### linq83: Min - Grouped
>This sample uses gets the cheapest price among each category's products.
```csharp
//c#
static void Linq83()
{
    var products = GetProductList();

    var categories = products
        .GroupBy(prod => prod.Category)
        .Select(prodGroup => 
            new
            {
                Category = prodGroup.Key, 
                CheapestPrice = prodGroup.Min(p => p.UnitPrice)
            });

    ObjectDumper.Write(categories);
}
```
```java
//java
public static void Linq83() {
    var products = Data.getProductList();

    var groupedByCategoryPrice = products.stream()
            .collect(Collectors.groupingBy(p -> p.category,
                    Collectors.minBy(Comparator.comparing(p -> p.unitPrice))));

    for(var key: groupedByCategoryPrice.keySet()) {
        var unitPrice = groupedByCategoryPrice.get(key).get().unitPrice;
        print("{Category: %s, CheapestPrice %.2f}", key, unitPrice);
    }
}
```
#### Output

    {Category: Grains/Cereals, CheapestPrice 7,00}
    {Category: Confections, CheapestPrice 9,20}
    {Category: Produce, CheapestPrice 10,00}
    {Category: Meat/Poultry, CheapestPrice 7,45}
    {Category: Seafood, CheapestPrice 6,00}
    {Category: Beverages, CheapestPrice 4,50}
    {Category: Dairy Products, CheapestPrice 2,50}
    {Category: Condiments, CheapestPrice 10,00}

### linq84: Min - Elements
>This sample gets the products with the lowest price in each category.
```csharp
//c#
static void Linq84()
{
    var products = GetProductList();

    var categories = products.GroupBy(prod => prod.Category)
        .Select(prodGroup => new {prodGroup, minPrice = prodGroup.Min(p => p.UnitPrice)})
        .Select(x => 
            new
            {
                Category = x.prodGroup.Key,
                CheapestProducts = x.prodGroup.Where(p => p.UnitPrice == x.minPrice)
            });

    ObjectDumper.Write(categories, 1);
}
```
```java
//java
public static void Linq84() {
    print("TODO");
}
```
#### Output

    {Category: Dairy Products, CheapestProducts: {{productId: 33, productName: Geitost, category: Dairy Products, unitPrice: 2.5, unitsInStock: 112}}}
    {Category: Grains/Cereals, CheapestProducts: {{productId: 52, productName: Filo Mix, category: Grains/Cereals, unitPrice: 7.0, unitsInStock: 38}}}
    {Category: Confections, CheapestProducts: {{productId: 19, productName: Teatime Chocolate Biscuits, category: Confections, unitPrice: 9.2, unitsInStock: 25}}}
    {Category: Seafood, CheapestProducts: {{productId: 13, productName: Konbu, category: Seafood, unitPrice: 6.0, unitsInStock: 24}}}
    {Category: Condiments, CheapestProducts: {{productId: 3, productName: Aniseed Syrup, category: Condiments, unitPrice: 10.0, unitsInStock: 13}}}
    {Category: Meat/Poultry, CheapestProducts: {{productId: 54, productName: Tourti�re, category: Meat/Poultry, unitPrice: 7.45, unitsInStock: 21}}}
    {Category: Produce, CheapestProducts: {{productId: 74, productName: Longlife Tofu, category: Produce, unitPrice: 10.0, unitsInStock: 4}}}
    {Category: Beverages, CheapestProducts: {{productId: 24, productName: Guaran� Fant�stica, category: Beverages, unitPrice: 4.5, unitsInStock: 20}}}

### linq85: Max - Simple
>This sample gets the highest number in an array. Note that the method returns a single value.
```csharp
//c#
static void Linq85()
{
    var numbers = new []{ 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var maxNum = numbers.Max();

    Console.WriteLine($"The maximum number is {maxNum}.");
}
```
```java
//java
public static void Linq85() {
    var numbers = new int []{ 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var maxNum = Arrays.stream(numbers).max().getAsInt();

    print("The maximum number is %d.", maxNum);
}
```
#### Output

    The maximum number is 9.

### linq86: Max - Projection
>This sample gets the length of the longest word in an array.
```csharp
//c#
static void Linq86()
{
    var words = new [] { "cherry", "apple", "blueberry" };

    var longestLength = words.Max(w => w.Length);

    Console.WriteLine($"The longest word is {longestLength} characters long.");
}
```
```java
//java
public static void Linq86() {
    var words = new String[] { "cherry", "apple", "blueberry" };

    var shortestWord = Arrays.stream(words)
            .mapToInt(w -> w.length())
            .max()
            .getAsInt();

    print("The longest word is %d characters long.", shortestWord);
}
```
#### Output

    The longest word is 9 characters long.

### linq87: Max - Grouped
>This sample gets the most expensive price among each category's products.
```csharp
//c#
static void Linq87()
{
    var products = GetProductList();

    var categories = products
        .GroupBy(prod => prod.Category)
        .Select(prodGroup => 
            new
            {
                Category = prodGroup.Key, 
                MostExpensivePrice = prodGroup.Max(p => p.UnitPrice)
            });

    ObjectDumper.Write(categories);
}
```
```java
//java
public static void Linq87() {
    var products = Data.getProductList();

    var groupedByCategoryPrice = products.stream()
            .collect(Collectors.groupingBy(p -> p.category,
                    Collectors.maxBy(Comparator.comparing(p -> p.unitPrice))));

    for(var key: groupedByCategoryPrice.keySet()) {
        var unitPrice = groupedByCategoryPrice.get(key).get().unitPrice;
        print("{Category: %s, MostExpensive %.2f}", key, unitPrice);
    }
```
#### Output

    {Category: Dairy Products, MostExpensivePrice: 55.0}
    {Category: Grains/Cereals, MostExpensivePrice: 38.0}
    {Category: Confections, MostExpensivePrice: 81.0}
    {Category: Seafood, MostExpensivePrice: 62.5}
    {Category: Condiments, MostExpensivePrice: 43.9}
    {Category: Meat/Poultry, MostExpensivePrice: 123.79}
    {Category: Produce, MostExpensivePrice: 53.0}
    {Category: Beverages, MostExpensivePrice: 263.5}

### linq88: Max - Elements
>This sample gets the products with the most expensive price in each category.
```csharp
//c#
static void Linq88()
{
    var products = GetProductList();

    var categories = products.GroupBy(prod => prod.Category)
        .Select(prodGroup => new {prodGroup, maxPrice = prodGroup.Max(p => p.UnitPrice)})
        .Select(x => 
            new
            {
                Category = x.prodGroup.Key,
                MostExpensiveProducts = x.prodGroup.Where(p => p.UnitPrice == x.maxPrice)
            });

    ObjectDumper.Write(categories, 1);
}
```
```java
//java
public static void Linq88() {
    print("TODO");
}
```
#### Output

    {Category: Dairy Products, MostExpensiveProducts: {{productId: 59, productName: Raclette Courdavault, category: Dairy Products, unitPrice: 55.0, unitsInStock: 79}}}
    {Category: Grains/Cereals, MostExpensiveProducts: {{productId: 56, productName: Gnocchi di nonna Alice, category: Grains/Cereals, unitPrice: 38.0, unitsInStock: 21}}}
    {Category: Confections, MostExpensiveProducts: {{productId: 20, productName: Sir Rodney's Marmalade, category: Confections, unitPrice: 81.0, unitsInStock: 40}}}
    {Category: Seafood, MostExpensiveProducts: {{productId: 18, productName: Carnarvon Tigers, category: Seafood, unitPrice: 62.5, unitsInStock: 42}}}
    {Category: Condiments, MostExpensiveProducts: {{productId: 63, productName: Vegie-spread, category: Condiments, unitPrice: 43.9, unitsInStock: 24}}}
    {Category: Meat/Poultry, MostExpensiveProducts: {{productId: 29, productName: Th�ringer Rostbratwurst, category: Meat/Poultry, unitPrice: 123.79, unitsInStock: 0}}}
    {Category: Produce, MostExpensiveProducts: {{productId: 51, productName: Manjimup Dried Apples, category: Produce, unitPrice: 53.0, unitsInStock: 20}}}
    {Category: Beverages, MostExpensiveProducts: {{productId: 38, productName: C�te de Blaye, category: Beverages, unitPrice: 263.5, unitsInStock: 17}}}

### linq89: Average - Simple
>This sample gets the average of all numbers in an array.
```csharp
//c#
static void Linq89()
{
    var numbers = new [] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var averageNum = numbers.Average();

    Console.WriteLine($"The average number is {averageNum}.");
}
```
```java
//java
public static void Linq89() {
    var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var averageNum = Arrays.stream(numbers).average().getAsDouble();

    print("The averages number is %.2f." , averageNum);
}
```
#### Output

    The averages number is 4,50.

### linq90: Average - Projection
>This sample gets the average length of the words in the array.
```csharp
//c#
static void Linq90()
{
    var words = new [] { "cherry", "apple", "blueberry" };

    var averageLength = words.Average(w => w.Length);

    Console.WriteLine($"The average word length is {averageLength} characters.");
}
```
```java
//java
public static void Linq90() {
    var words = new String[] { "cherry", "apple", "blueberry" };

    var averageWordLength = Arrays.stream(words)
            .mapToInt(w -> w.length())
            .average()
            .getAsDouble();

    print("The shortest word is %f characters long.", averageWordLength);
}
```
#### Output

    The average word length is 6.666666666666667 characters.

### linq91: Average - Grouped
>This sample gets the average price of each category's products.
```csharp
//c#
static void Linq91()
{
    var  products = GetProductList();

    var categories = products
        .GroupBy(prod => prod.Category)
        .Select(prodGroup => 
            new
            {
                Category = prodGroup.Key, 
                AveragePrice = prodGroup.Average(p => p.UnitPrice)
            });

    ObjectDumper.Write(categories);
}
```
```java
//java
    public static void Linq91() {
        print("TODO");
    }
```
#### Output

    {Category: Dairy Products, AveragePrice: 28.73}
    {Category: Grains/Cereals, AveragePrice: 20.25}
    {Category: Confections, AveragePrice: 25.16}
    {Category: Seafood, AveragePrice: 20.6825}
    {Category: Condiments, AveragePrice: 23.0625}
    {Category: Meat/Poultry, AveragePrice: 54.00666666666667}
    {Category: Produce, AveragePrice: 32.37}
    {Category: Beverages, AveragePrice: 37.979166666666664}

### linq92: Aggregate - Simple
>This sample uses creates a running product on the array that calculates the total product of all elements.
```csharp
//c#
static void Linq92()
{
    var doubles = new [] { 1.7, 2.3, 1.9, 4.1, 2.9 };

    var product = doubles.Aggregate((runningProduct, nextFactor) => runningProduct * nextFactor);

    Console.WriteLine($"Total product of all numbers: {product}");
}
```
```java
//java
public static void Linq92() {
    var doubles = new double[] { 1.7, 2.3, 1.9, 4.1, 2.9 };

    var product = Arrays.stream(doubles)
            .reduce((runningTotal, nextFactor) -> runningTotal * nextFactor)
            .getAsDouble();

    print("Total product of all numbers: %f" , product);
}
```
#### Output

    Total product of all numbers: 88.33080999999999

### linq93: Aggregate - Seed
>This sample uses to creates a running account balance that subtracts each withdrawal from the initial balance of 100, as long as the balance never drops below 0.
```csharp
//c#
static void Linq93()
{
    var startBalance = 100.0;

    var attemptedWithdrawals = new []{ 20, 10, 40, 50, 10, 70, 30 };

    var endBalance = attemptedWithdrawals
        .Aggregate(startBalance, 
                    (balance, nextWithdrawal) =>
                    ((nextWithdrawal <= balance) ? (balance - nextWithdrawal) : balance));

    Console.WriteLine($"Ending balance: {endBalance}");
}   
```
```java
//java
public static void Linq93() {
    int startBalance = 100;

    var attemptedWithdrawals = new int[]{ 20, 10, 40, 50, 10, 70, 30 };

    var endBalance = Arrays.stream(attemptedWithdrawals)
            .reduce(startBalance,
                    (balance, nextWithdrawal) ->
                            (nextWithdrawal <= balance) ? (balance - nextWithdrawal) : balance);

    print("Ending balance: %d",  endBalance);
}
```
#### Output

    Ending balance: 20.0


LINQ - Miscellaneous Operators
------------------------------

### linq94: Concat - 1
>This sample creates a contatenation of each array's values, one after the other.
```csharp
//c#
static void Linq94()
{
    int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
    int[] numbersB = { 1, 3, 5, 7, 8 };

    var allNumbers = numbersA.Concat(numbersB);

    Console.WriteLine("All numbers from both arrays:");
    allNumbers.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq94() {
    int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
    int[] numbersB = { 1, 3, 5, 7, 8 };

    var allNumbers = Stream
            .concat(
                    Arrays.stream(numbersA).boxed(),
                    Arrays.stream(numbersB).boxed());

    print("All numbers from both arrays:");
    allNumbers.forEach(System.out::println);
}
```
#### Output

    All numbers from both arrays:
    0
    2
    4
    5
    6
    8
    9
    1
    3
    5
    7
    8

### linq95: Concat - 2
>This sample creates a contatenation that contains the names of all customers and products, including any duplicates.
```csharp
//c#
static void Linq95()
{
    var customers = GetCustomerList();
    var products = GetProductList();

    var customerNames = customers.Select(cust => cust.CompanyName);
    var productNames = products.Select(prod => prod.ProductName);

    var allNames = customerNames.Concat(productNames);

    Console.WriteLine("Customer and product names:");
    allNames.ForEach(Console.WriteLine);
}
```
```java
//java
public static void Linq95() {
    var products = Data.getProductList();
    var customers = Data.getCustomerList();

    var customerNames = customers.stream().map(c -> c.companyName);
    var productNames = products.stream().map(p -> p.productName);


    var allNames = Stream.concat(customerNames, productNames);

    print("Customer and product names:");
    allNames.forEach(System.out::println);
}
```
#### Output

    Customer and product names:
    Alfreds Futterkiste
    Ana Trujillo Emparedados y helados
    Antonio Moreno Taquer�a
    Around the Horn
    Berglunds snabbk�p
    Blauer See Delikatessen
    ...

### linq96: EqualAll - 1
>This sample checks if two sequences match on all elements in the same order
```csharp
//c#
static void Linq96()
{
    var wordsA = new[] { "cherry", "apple", "blueberry" };
    var wordsB = new[] { "cherry", "apple", "blueberry" };

    var match = wordsA.SequenceEqual(wordsB);

    Console.WriteLine($"The sequences match: {match}");
}
```
```java
//java
public static void Linq96() {
    var wordsA = new String[] { "cherry", "apple", "blueberry" };
    var wordsB = new String[] { "cherry", "apple", "blueberry" };

    var equal = Arrays.equals(wordsA, wordsB);

    print("The sequences match: %s", equal);
}
```
#### Output

    The sequences match: True

### linq97: EqualAll - 2
>This sample checks if two sequences match on all elements in the same order.
```csharp
//c#
static void Linq97()
{
    var wordsA = new[] { "cherry", "apple", "blueberry" };
    var wordsB = new[] { "apple", "blueberry", "cherry" };

    var match = wordsA.SequenceEqual(wordsB);

    Console.WriteLine($"The sequences match: {match}");
}   
```
```java
//java
public static void Linq97() {
    var wordsA = new String[] { "cherry", "apple", "blueberry" };
    var wordsB = new String[]  { "apple", "blueberry", "cherry" };

    var equal = Arrays.equals(wordsA, wordsB);

    print("The sequences match: %s", equal);
}
```
#### Output

    The sequences match: False

LINQ - Query Execution
----------------------

### linq99: Deferred Execution
>The following sample shows how query execution is deferred until the query is enumerated at a foreach statement.
```csharp
//c#
static void Linq99()
{
    // Queries are not executed until you enumerate over them.
    var numbers = new[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    int i = 0;
    var simpleQuery = numbers
        .Select(x => i++);

    // The local variable 'i' is not incremented until the query is executed in the foreach loop.
    Console.WriteLine($"The current value of i is {i}"); //i is still zero

    simpleQuery.ForEach(item => Console.WriteLine($"v = {item}, i = {i}")); // now i is incremented          
}
```
```java
//java
public static void Linq99() {
    print("TODO");
}
```
#### Output

    v = 1, i = 1
    v = 2, i = 2
    v = 3, i = 3
    v = 4, i = 4
    v = 5, i = 5
    v = 6, i = 6
    v = 7, i = 7
    v = 8, i = 8
    v = 9, i = 9
    v = 10, i = 10

### linq100: Immediate Execution
>The following sample shows how queries can be executed immediately, and their results stored in memory, with methods such as ToList/list.
```csharp
//c#
static void Linq100()
{
    // Methods like ToList(), Max(), and Count() cause the query to be executed immediately.            
    var numbers = new[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

    var i = 0;
    var immediateQuery = numbers
        .Select(x =>  ++i)
        .ToList();

    Console.WriteLine("The current value of i is {0}", i); //i has been incremented

    immediateQuery.ForEach(item => Console.WriteLine($"v = {item}, i = {i}"));
}
```
```java
//java
public static void Linq100() {
    print("TODO");
}
```
#### Output

    v = 1, i = 10
    v = 2, i = 10
    v = 3, i = 10
    v = 4, i = 10
    v = 5, i = 10
    v = 6, i = 10
    v = 7, i = 10
    v = 8, i = 10
    v = 9, i = 10
    v = 10, i = 10

### linq101: Query Reuse
>The following sample shows how, because of deferred execution, queries can be used again after data changes and will then operate on the new data.
```csharp
//c#
static void Linq101()
{
    // Deferred execution lets us define a query once and then reuse it later in various ways.
    var numbers = new[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
    var lowNumbers = numbers
        .Where(num => num <= 3);

    Console.WriteLine("First run numbers <= 3:");
    lowNumbers.ForEach(Console.WriteLine);

    // Modify the source data.
    for (var i = 0; i < 10; i++)
    {
        numbers[i] = -numbers[i];
    }

    // During this second run, the same query object,
    // lowNumbers, will be iterating over the new state
    // of numbers[], producing different results:
    Console.WriteLine("Second run numbers <= 3:");
    lowNumbers.ForEach(Console.WriteLine);
}   
```
```java
//java
public static void Linq101() {
    print("TODO");
}
```
#### Output

    First run numbers <= 3:
    1
    3
    2
    0
    Second run numbers <= 3:
    -5
    -4
    -1
    -3
    -9
    -8
    -6
    -7
    -2
    0

