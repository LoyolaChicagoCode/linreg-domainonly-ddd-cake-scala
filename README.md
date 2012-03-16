Deliberately overengineered to illustrate domain-driven design and 
dependency injection using the Cake idiom.

Some key insights:

- Because non-configurable stateless components are conceptually
  singletons, concrete implementation components can provide them as
  singleton Scala objects.
  
- Abstract components whose implementations are stateful should
  provide an abstract factory method to allow test clients to create
  multiple instances of the component implementation. Concrete
  implementations should implement the factory method by instantiating
  the concrete class provided by the concrete implementation
  component.
