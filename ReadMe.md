the packages are structured by features. so that all classes needed for that feature is in the same package.
Other way to structure is package by layers like controllers, repository, entity etc.

Record is a special kind of class.They reduce boilerplate code by automatically generating boilerplate code such as constructors, accessors, equals(), hashCode(), and toString() methods.

validation dipendency can be used to validate data
@Valid annotation validate the object based on the rules defined

we are using H2 database as database for the app