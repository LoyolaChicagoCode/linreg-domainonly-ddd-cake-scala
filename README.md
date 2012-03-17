Deliberately overengineered to illustrate domain-driven design and 
dependency injection using the Cake idiom.

Some key insights:

- Because stateless components are conceptually singletons, a concrete
  non-configurable implementation component can define an instance as
  singleton Scala object.
  
- Abstract components whose implementations are stateful should not
  define an instance so as to enable test clients to create fresh
  instances of the component implementation as needed.
  
