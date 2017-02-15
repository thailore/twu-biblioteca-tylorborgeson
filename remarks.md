- nice use of String.format !
- mainMenu is nice and compact.

General (OOP related) stuff:
- try separating UI and data model
  * e.g.
    library: findBooks -- instead of printing the book list, return the object with the books. have a separated class responsible for printing Books. This way you may reuse this printing when showing the list of books a customer has currently checked out, etc.
    (might be a bit over the top, but it's a nice exercise.) Also this allows to quickly change the presentation if for example you'll want to switch away from simple console logging.
  * This of course also helps with testing: You can test your (complex) business logic (e.g. expecting a Book to be available after returning it) by investigating the domain object (e.g. List<Book> object) instead of evaluation the printed String statements.

- avoid static if possible. Right now, your app mainly relies on static methods/ variables etc. -> it's easy to start coding this way but you're restricting the usage unnecessarily (e.g. you're restricted to one library)
- instead have one place to configure all necessary components (good place for that is the BibApp class) and inject the dependencies of the component in its constructor -- related reads: Dependency Injection, Constructor Injection
- the two above combined will make testing a lot easier (see below).

- Book - constructor: Do not add a new Book to the library in the Book constructor: This is very confusing and unexpected behavior. Also it's probably a wrong abstraction: Thinking that your code is a model of the real world; it's not a books responsibility to add itself to a library. Rather have a `addBook(Book)` method in the Library class!  
- Book.bookAvailable -- the same problem with finding the right place for this information: How would a book know whether it is available. In the context of a single Book, what does being available even mean? -> I'd argue that the Library would know whether a book is available (by inspecting it's bookList)

- try to apply the SOLID principles (checkout wiki): especially be sure about the 'Single Responsibility' part. Each component should serve one responsibility. E.g: validateUserInput in mainMenu does two things. Validating _and in case it fails, read a new value_ . Instead the validate method should really only do that -- return a boolean value if the input is valid or not. The calling method may decide on how to handle invalid input.

- Avoid side effects: (Always!) try to avoid changing the input parameters of your methods. Instead, return the new value explicitly. This is a very common source of bugs, as a caller might not be aware that you are changing the input parameters. (see validateUserInput)
This rule is not java specific but holds true for basically every programming language. If you stick to it, you'll get cleaner code that is easier to test.


Java specific stuff (feedback and hints)
- stick to Java Naming Conventions:
  * Classes start with capital letter
  * libraryList: as Java is strongly typed, it is uncommon to include types (e.g. List suffix is unnecessary)
  * usually you'll find properties (fields) private with getter/setter methods. this is a subjective matter, but devs that did java as a first language will look strange at you ;) -- also it can lead to problems with data encaps (see below). Even if this feels strange at first, it's probably good to stick to established language conventions
  * getters for boolean field X: isX() (e.g. isBookAvailable() in Book class)
  * don't include the classes name in methods of the class (e.g. Book.getBookTitle()): as we're strongly typed, we always know what title is meant when we call .getTitle() on a Book object.

- checkout the Collections API and its data types: currently you use your ArrayList of Books like a plain Array. While this is one step ahead of using a Book[] array, you are not leveraging the Lists API. Also think/research the other types you get for free like Sets and Maps (synonym to Dictionaries in python I believe). findBookLocation is working quite inefficient right now.

- watch out for data encapsulation
  * library.java: exposing the libraryList violates the data encapsulation as code somewhere outside the class can change the List arbitrarily or even set the field to null. Latter can be avoided by making the field final, which is always good. But it won't prevent other classes from adding, removing or clearing the List once they obtain it.

  Thinking about encapsulation in OOP could mean to not make the field public at all and not having without getters/setters if possible.

  On that topic, using immutable data structures is also a very good practice. Unfortunately it is not simple or native to do in Java and takes some time to get used to as well as appreciating it. It is a more advanced topic that you don't need to know right now, but I guess it's good to know it exists and to fiddle with it once you have some free time.


- findBook: method redundant as there is a contains() method on List<?> objects.
  * This will only work if you implement equals() - and hash(). I recommend to study Java's equals/hash contract. This is essential for  Java programs and the very popular Collection classes and is a very common source of confusion if you don't know about it.
  * along with the equals stuff, be sure to know the difference between == and equals (if you don't know already of course).

- Java's primitives do not act like all other java Objects:
  i.e. validateUserInput in mainMenu() does not work as you expect - the validation itself is okay, but reassigning it will actually not change the value in the calling method. the new value never leaves the validateUserInput method. Instead you'd have to return the new value. This is because primitive parameters are call-by-value parameters.

  Objects on the other hand are call-by-reference parameters (everything except for int, byte, char, float, double, boolean). Therefor you could change them (by calling methods on them) and it would reflect on the outside of the method. (don't do it however, see above :D)

  Reassigning a parameter in methods however will NEVER change the value outside the method -- Java treads parameters as variables. assigning a new value to them will only change the variable locally in the method (and you'll loose the original parameter). It is a good practice to declare parameters final, so you don't change them by accident (e.g. public void foo (final String param) {...})


Testing:
- Your test is a good test for the Library class and tests its feature quite extensively. If you separate your UI code from the business logic, it will be even easier to test.

- Testing UI with automated tests is hard because it involves simulating User input. It is possible however, if you redirect System.in and prepare an input buffer. This way you could test if your main menu behaves as expected (e.g. what happens if I enter some invalid number?). I would consider this optional.


Nice to know - IntelliJ shortcuts:
- CMD + N: helps you generate standard boiler code like getters/setter , equals/hash /toString etc.
