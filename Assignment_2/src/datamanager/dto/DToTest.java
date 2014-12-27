package datamanager.dto;

import java.io.File;
import java.util.ArrayList;

import domain.*;

public class DToTest {

	public static void main(String[] args) {
		DTOFacade facade = new DTOFacade();
								
			//Patterns
			//Creational - scopeClass
			Pattern factoryMethod = new Pattern("Factory", true, "The factory class will deal with the problem of creating object without specifiying the exact class");
			//Structural - scopeClass
			Pattern adapterClass = new Pattern("Adapter (class)", true, "This pattern uses multiple polymophic interfaces to implementing or inheriting both the interface that is expected and the interface that is pre-existing");
			//Behavioral - scopeClass
			Pattern interpreter = new Pattern("Interpreter", true, "This pattern specifies how to evaluate sentences in a language");
			Pattern templateMethod = new Pattern("Template Method", true, "This pattern defines the program skeleton of an algorithm in a method");
			//Creational - scopeObject
			Pattern abstractFactory = new Pattern("Abstract Factory", true, "This pattern provides a way to encapsulate a group of individual factories that have a common theme without specifiying their concrete classes");
			Pattern builder = new Pattern("Builder", true, "This intention of this patern is to find a solution to the telescoping constructor anti-pattern");
			Pattern prototype = new Pattern("Prototype", true, "This pattern is used when the type of objects to create is determined by a prototypical instance, which is cloned to produce new objects");
			Pattern singleton = new Pattern("Singleton", true, "This pattern restricts the instantiation of a class to one object");
			//Structual - scopeObject
			Pattern adapterObject = new Pattern("Adapter (object)", true, "This pattern constains an instance of the class it wraps, the adapter makes class to the instance of the wrapped object");
			Pattern bridge = new Pattern("Bridge", true, "This pattern is eant to decouple an abstraction from its implementation so that the two can vary independently");
			Pattern composite = new Pattern("Composite", true, "This pattern describes that a group of objects is to be treated in the same way as a single intance of an object");
			Pattern decorator = new Pattern("Decorator" , true, "This pattern allows behavior to be added to an individual object, either statically or dunamically, without affecting the behavior of other objects from the same class");
			Pattern façade = new Pattern("Facade", true, "The facade class wich you use in this pattern provides a simplified interface to a larger body of code (package)");
			Pattern flyweight = new Pattern("Flyweight", true, "This pattern has an object that minimizes memory use by sharing as much data as possible with other similar objects");
			Pattern proxy = new Pattern("Proxy", true, "This pattern has a class functioning as an interface to something else");
			//Behavioral - scopeObject
			Pattern chain = new Pattern("Chain of Responsibility", true, " This pattern constists of a source of command objects and a series of processing objects");
			Pattern command = new Pattern("Command", true, "This pattern has an object that is used to represent and encapsulate all the information needed to call a method at a later time");
			Pattern iterator = new Pattern("Iterator", true, "This pattern is used to traverse a container and acces the container's elements");
			Pattern mediator = new Pattern("Mediator", true, "This pattern defines an object that encapsulates how a set of objects interact");
			Pattern memento = new Pattern("Memento", true, "This pattern provides the ability to restore an oject to its previous  state");
			Pattern observer = new Pattern("Observer", true, "This pattern has an object called the subject, ti maintains a list of its dependents, called observerrs, and notifies them automatically of any state changes, usually by calling one of their methods" );
			Pattern state = new Pattern("State", true, "This pattern is used to encapsulate varying behaviour for the same routine based on an object's state object");
			Pattern strategy = new Pattern("Strategy", true, "This pattern enables an algorithm's behavior t be selected at runtime");
			Pattern visitor = new Pattern("Visitor", true,"This pattern is a way of separating an algorithm from an objects structure on which it operates");
			
			
				//Diagram
				File factoryMethod_File = new File("factorymethod.xml");
				factoryMethod.setDiagram(factoryMethod_File);
				File adapterClass_File = new File("adapterClass.xml");
				adapterClass.setDiagram(adapterClass_File);
				File interpreter_File = new File("interpreter.xml");
				interpreter.setDiagram(interpreter_File);
				File templateMethod_File = new File("templateMethod.xml");
				templateMethod.setDiagram(templateMethod_File);
				File abstractFactory_File = new File("abstractFactory.xml");
				abstractFactory.setDiagram(abstractFactory_File);
				File builder_File = new File("builder.xml");
				builder.setDiagram(builder_File);
				File prototype_File = new File("prototype.xml");
				prototype.setDiagram(prototype_File);
				File singleton_File = new File("singleton.xml");
				singleton.setDiagram(singleton_File);
				File adapterObject_File = new File("adapterObject.xml");
				adapterObject.setDiagram(adapterObject_File);
				File bridge_File = new File("bridge.xml");
				bridge.setDiagram(bridge_File);
				File composite_File = new File("composite.xml");
				composite.setDiagram(composite_File);
				File decorator_file = new File("decorator.xml");
				decorator.setDiagram(decorator_file);
				File façade_file = new File("façade.xml");
				façade.setDiagram(façade_file);
				File flyweight_File = new File("flyweight.xml");
				flyweight.setDiagram(flyweight_File);
				File proxy_File = new File("proxy.xml");
				proxy.setDiagram(proxy_File);
				File chain_File = new File("chain.xml");
				chain.setDiagram(chain_File);
				File command_File = new File("command.xml");
				command.setDiagram(command_File);
				File iterator_File = new File("iterator.xml");
				iterator.setDiagram(iterator_File);
				File mediator_File = new File("mediator.xml");
				mediator.setDiagram(mediator_File);
				File memento_File = new File("memento.xml");
				memento.setDiagram(memento_File);
				File observer_File = new File("observer.xml");
				observer.setDiagram(observer_File);
				File state_File = new File("state.xml");
				state.setDiagram(state_File);
				File strategy_File = new File("strategy.xml");
				strategy.setDiagram(strategy_File);
				File visitor_File = new File("visitor.xml");
				visitor.setDiagram(visitor_File);
				
				//AKA
				factoryMethod.setAka("FM");
				adapterClass.setAka("AC");
				interpreter.setAka("IP");
				templateMethod.setAka("TM");
				abstractFactory.setAka("AF");
				builder.setAka("BU");
				prototype.setAka("Proto");
				singleton.setAka("Single");
				adapterObject.setAka("AO");
				bridge.setAka("BR");
				composite.setAka("CO");
				decorator.setAka("DE");
				façade.setAka("Faç");
				flyweight.setAka("Fly");
				proxy.setAka("Prox");
				chain.setAka("Chain");
				command.setAka("CO");
				iterator.setAka("IT");
				mediator.setAka("MED");
				memento.setAka("MEM");
				observer.setAka("OB");
				state.setAka("ST");
				strategy.setAka("STRAT");
				visitor.setAka("VIS");
				
				//Pros
				factoryMethod.setPros("Pro1");
				adapterClass.setPros("Pro1");
				interpreter.setPros("Pro1");
				templateMethod.setPros("Pro1");
				abstractFactory.setPros("Pro1");
				builder.setPros("Pro1");
				prototype.setPros("Pro1");
				singleton.setPros("Pro1");
				adapterObject.setPros("Pro1");
				bridge.setPros("Pro1");
				composite.setPros("Pro1");
				decorator.setPros("Pro1");
				façade.setPros("Pro1");
				flyweight.setPros("Pro1");
				proxy.setPros("Pro1");
				chain.setPros("Pro1");
				command.setPros("Pro1");
				iterator.setPros("Pro1");
				mediator.setPros("Pro1");
				memento.setPros("Pro1");
				observer.setPros("Pro1");
				state.setPros("Pro1");
				strategy.setPros("Pro1");
				visitor.setPros("Pro1");
				
				//Cons
				factoryMethod.addCon("Con1");
				adapterClass.addCon("Con1");
				interpreter.addCon("Con1");
				templateMethod.addCon("Con1");
				abstractFactory.addCon("Con1");
				builder.addCon("Con1");
				prototype.addCon("Con1");
				singleton.addCon("Con1");
				adapterObject.addCon("Con1");
				bridge.addCon("Con1");
				composite.addCon("Con1");
				decorator.addCon("Con1");
				façade.addCon("Con1");
				flyweight.addCon("Con1");
				proxy.addCon("Con1");
				chain.addCon("Con1");
				command.addCon("Con1");
				iterator.addCon("Con1");
				mediator.addCon("Con1");
				memento.addCon("Con1");
				observer.addCon("Con1");
				state.addCon("Con1");
				strategy.addCon("Con1");
				visitor.addCon("Con1");
			
				//Category
					//Purpose
					Purpose creational = new Purpose("Creational");
					Purpose structural = new Purpose("Structural");
					Purpose behavioral = new Purpose("Behavioral");
					
					//Scope
					Scope scopeClass = new Scope("Class");
					Scope scopeObject = new Scope("Object");
					
				factoryMethod.addCategory(scopeClass);
				factoryMethod.addCategory(creational);
				
				adapterClass.addCategory(structural);
				adapterClass.addCategory(scopeClass);
				
				interpreter.addCategory(scopeClass);
				interpreter.addCategory(behavioral);
				
				templateMethod.addCategory(scopeClass);
				templateMethod.addCategory(behavioral);
				
				abstractFactory.addCategory(scopeObject);
				abstractFactory.addCategory(creational);
				
				builder.addCategory(scopeObject);
				builder.addCategory(creational);
				
				prototype.addCategory(scopeObject);
				prototype.addCategory(creational);
				
				singleton.addCategory(scopeObject);
				singleton.addCategory(creational);
				
				adapterObject.addCategory(scopeObject);
				adapterObject.addCategory(structural);
				
				bridge.addCategory(scopeObject);
				bridge.addCategory(structural);
				
				composite.addCategory(scopeObject);
				composite.addCategory(structural);
				
				decorator.addCategory(scopeObject);
				decorator.addCategory(structural);
				
				façade.addCategory(scopeObject);
				façade.addCategory(structural);
				
				flyweight.addCategory(scopeObject);
				flyweight.addCategory(structural);
				
				proxy.addCategory(scopeObject);
				proxy.addCategory(structural);
				
				chain.addCategory(scopeObject);
				chain.addCategory(behavioral);
				
				command.addCategory(scopeObject);
				command.addCategory(behavioral);
				
				iterator.addCategory(scopeObject);
				iterator.addCategory(behavioral);
				
				mediator.addCategory(scopeObject);
				mediator.addCategory(behavioral);
				
				memento.addCategory(scopeObject);
				memento.addCategory(behavioral);
				
				observer.addCategory(scopeObject);
				observer.addCategory(behavioral);
				
				state.addCategory(scopeObject);
				state.addCategory(behavioral);
				
				strategy.addCategory(scopeObject);
				strategy.addCategory(behavioral);
				
				visitor.addCategory(scopeObject);
				visitor.addCategory(behavioral);
				
				//Participants
			
				// ----------------- moet nog---------------------------------------------------------------------------
				
				//Forces
				Force factoryMethod_Force = new Force("Force test");
				Force adapterClass_Force = new Force("Force test");
				Force interpreter_Force = new Force("Force test");
				Force templateMethod_Force = new Force("Force test");
				Force abstractFactory_Force = new Force("Force test");
				Force builder_Force = new Force("Force test");
				Force prototype_Force = new Force("Force test");
				Force singleton_Force = new Force("Force test");
				Force adapterObject_Force = new Force("Force test");
				Force bridge_Force = new Force("Force test");
				Force composite_Force = new Force("Force test");
				Force decorator_Force = new Force("Force test");
				Force façade_Force = new Force("Force test");
				Force flyweight_Force = new Force("Force test");
				Force proxy_Force = new Force("Force test");
				Force chain_Force = new Force("Force test");
				Force command_Force = new Force("Force test");
				Force iterator_Force = new Force("Force test");
				Force mediator_Force = new Force("Force test");
				Force memento_Force = new Force("Force test");
				Force observer_Force = new Force("Force test");
				Force state_Force = new Force("Force test");
				Force strategy_Force = new Force("Force test");
				Force visitor_Force = new Force("Force test");
						
				//Problem
				Problem factoryMethod_Problem = new Problem("Problem test");
				Problem adapterClass_Problem  = new Problem("Problem test");
				Problem interpreter_Problem  = new Problem("Problem test");
				Problem templateMethod_Problem  = new Problem("Problem test");
				Problem abstractFactory_Problem  = new Problem("Problem test");
				Problem builder_Problem  = new Problem("Problem test");
				Problem prototype_Problem  = new Problem("Problem test");
				Problem singleton_Problem  = new Problem("Problem test");
				Problem adapterObject_Problem  = new Problem("Problem test");
				Problem bridge_Problem  = new Problem("Problem test");
				Problem composite_Problem  = new Problem("Problem test");
				Problem decorator_Problem  = new Problem("Problem test");
				Problem façade_Problem  = new Problem("Problem test");
				Problem flyweight_Problem  = new Problem("Problem test");
				Problem proxy_Problem  = new Problem("Problem test");
				Problem chain_Problem  = new Problem("Problem test");
				Problem command_Problem  = new Problem("Problem test");
				Problem iterator_Problem  = new Problem("Problem test");
				Problem mediator_Problem  = new Problem("Problem test");
				Problem memento_Problem  = new Problem("Problem test");
				Problem observer_Problem  = new Problem("Problem test");
				Problem state_Problem  = new Problem("Problem test");
				Problem strategy_Problem  = new Problem("Problem test");
				Problem visitor_Problem  = new Problem("Problem test");
				
				factoryMethod_Problem.addSolution(factoryMethod);
				adapterClass_Problem.addSolution(adapterClass);
				interpreter_Problem.addSolution(interpreter);
				templateMethod_Problem.addSolution(templateMethod);
				abstractFactory_Problem.addSolution(abstractFactory);
				builder_Problem.addSolution(builder);
				prototype_Problem.addSolution(prototype);
				singleton_Problem.addSolution(singleton);
				adapterObject_Problem.addSolution(adapterObject);
				bridge_Problem.addSolution(bridge);
				composite_Problem.addSolution(composite);
				decorator_Problem.addSolution(decorator);
				façade_Problem.addSolution(façade);
				flyweight_Problem.addSolution(flyweight);
				proxy_Problem.addSolution(proxy);
				chain_Problem.addSolution(chain);
				command_Problem.addSolution(command);
				iterator_Problem.addSolution(iterator);
				mediator_Problem.addSolution(mediator);
				memento_Problem.addSolution(memento);
				observer_Problem.addSolution(observer);
				state_Problem.addSolution(state);
				strategy_Problem.addSolution(strategy);
				visitor_Problem.addSolution(visitor);
				
				factoryMethod_Problem.addForce(factoryMethod_Force);
				adapterClass_Problem.addForce(adapterClass_Force); 
				interpreter_Problem.addForce(interpreter_Force); 
				templateMethod_Problem.addForce(templateMethod_Force) ;
				abstractFactory_Problem.addForce(abstractFactory_Force); 
				builder_Problem.addForce(builder_Force); 
				prototype_Problem.addForce(prototype_Force) ;
				singleton_Problem.addForce(singleton_Force) ;
				adapterObject_Problem.addForce(adapterObject_Force) ;
				bridge_Problem.addForce(bridge_Force) ;
				composite_Problem.addForce(composite_Force) ;
				decorator_Problem.addForce(decorator_Force) ;
				façade_Problem.addForce(façade_Force) ;
				flyweight_Problem.addForce(flyweight_Force) ;
				proxy_Problem.addForce(proxy_Force) ;
				chain_Problem.addForce(chain_Force) ;
				command_Problem.addForce(command_Force) ;
				iterator_Problem.addForce(iterator_Force) ;
				mediator_Problem.addForce(mediator_Force) ;
				memento_Problem.addForce(memento_Force) ;
				observer_Problem.addForce(observer_Force) ;
				state_Problem.addForce(state_Force) ;
				strategy_Problem.addForce(strategy_Force) ;
				visitor_Problem.addForce(visitor_Force) ;
				
				//Context
				Context factoryMethod_Context = new Context("description" , "example");
				Context adapterClass_Context = new Context("description" , "example");
				Context interpreter_Context = new Context("description" , "example");
				Context templateMethod_Context = new Context("description" , "example");
				Context abstractFactory_Context = new Context("description" , "example");
				Context builder_Context = new Context("description" , "example");
				Context prototype_Context = new Context("description" , "example");
				Context singleton_Context = new Context("description" , "example");
				Context adapterObject_Context = new Context("description" , "example");
				Context bridge_Context = new Context("description" , "example");
				Context composite_Context = new Context("description" , "example");
				Context decorator_Context = new Context("description" , "example");
				Context façade_Context = new Context("description" , "example");
				Context flyweight_Context = new Context("description" , "example");
				Context proxy_Context = new Context("description" , "example");
				Context chain_Context = new Context("description" , "example");
				Context command_Context = new Context("description" , "example");
				Context iterator_Context = new Context("description" , "example");
				Context mediator_Context = new Context("description" , "example");
				Context memento_Context = new Context("description" , "example");
				Context observer_Context = new Context("description" , "example");
				Context state_Context = new Context("description" , "example");
				Context strategy_Context = new Context("description" , "example");
				Context visitor_Context = new Context("description" , "example");
				
			
			
			
		ArrayList<Pattern> patterns = new ArrayList<Pattern>();
		patterns.add(factoryMethod);
		patterns.add(adapterClass);
		patterns.add(interpreter);
		patterns.add(templateMethod);
		patterns.add(abstractFactory);
		patterns.add(builder);
		patterns.add(prototype);
		patterns.add(singleton);
		patterns.add(adapterObject);
		patterns.add(bridge);
		patterns.add(composite);
		patterns.add(decorator);
		patterns.add(façade);
		patterns.add(flyweight);
		patterns.add(proxy);
		patterns.add(chain);
		patterns.add(command);
		patterns.add(iterator);
		patterns.add(mediator);
		patterns.add(memento);
		patterns.add(observer);
		patterns.add(state);
		patterns.add(strategy);
		patterns.add(visitor);
		
		ArrayList<Context> allContexts = new ArrayList<Context>();
		allContexts.add(factoryMethod_Context);
		allContexts.add(adapterClass_Context);
		allContexts.add(interpreter_Context);
		allContexts.add(templateMethod_Context);
		allContexts.add(abstractFactory_Context);
		allContexts.add(builder_Context);
		allContexts.add(prototype_Context);
		allContexts.add(singleton_Context);
		allContexts.add(adapterObject_Context);
		allContexts.add(bridge_Context);
		allContexts.add(composite_Context);
		allContexts.add(decorator_Context);
		allContexts.add(façade_Context);
		allContexts.add(flyweight_Context);
		allContexts.add(proxy_Context);
		allContexts.add(chain_Context);
		allContexts.add(command_Context);
		allContexts.add(iterator_Context);
		allContexts.add(mediator_Context);
		allContexts.add(memento_Context);
		allContexts.add(observer_Context);
		allContexts.add(state_Context);
		allContexts.add(strategy_Context);
		allContexts.add(visitor_Context);
		
		ArrayList<Category> categories = new ArrayList<Category>();
		categories.add(scopeObject);
		categories.add(scopeClass);
		categories.add(behavioral);
		categories.add(creational);
		categories.add(structural);
		
		facade.writeAllPatternNames(patterns);
		facade.writeAllContexts(allContexts);
		facade.writeAllCategories(categories);
		String path = null;
		File file = null;
		for(int i = 0; i < patterns.size(); i++){
			facade.createDocument();
			Pattern patternTemp = patterns.get(i);
			path = patternTemp.getDiagram().getPath();
			Object obj = (Object) patternTemp;
			facade.writeDocument(obj, "pattern");
			ArrayList<Category> categoryTemp = new ArrayList<Category>();
			categoryTemp = patternTemp.getCategories();
			for(int j = 0; j < categoryTemp.size(); j++){
				obj = (Object) categoryTemp.get(j);
				if(categoryTemp.get(j).getClass().getName() == "domain.Scope"){
					facade.writeDocument(obj, "scope");
				}
				else{
					facade.writeDocument(obj, "purpose");
				}
			}
			ArrayList<Context> contextTemp = new ArrayList<Context>();
			contextTemp = patternTemp.getContexts();
			for(int k = 0; k < contextTemp.size(); k++){
				obj = (Object) contextTemp.get(k);
				facade.writeDocument(obj, "context");
			}
			ArrayList<Participant> participantTemp = new ArrayList<Participant>();
			participantTemp = patternTemp.getParticipants();
			for(int l = 0; l< participantTemp.size(); l++){
				obj = (Object) participantTemp.get(l);
				facade.writeDocument(obj, "participant");
			}
			ArrayList<Problem> allProblems = new ArrayList<Problem>();
			ArrayList<Solution> solutionTemp = new ArrayList<Solution>();
			allProblems = Problem.getAllProblems();
			for(int m = 0; m < allProblems.size(); m++){
				Problem problemTemp = allProblems.get(m);
				solutionTemp = problemTemp.getSolutions();
				for(int n = 0; n < solutionTemp.size(); n++){
					if(solutionTemp.get(n) == patternTemp){
						obj = (Object) problemTemp;
						facade.writeDocument(obj, "problem");
						ArrayList<Force> forceTemp = new ArrayList<Force>();
						forceTemp = problemTemp.getForces();
						for(int o = 0; o < forceTemp.size(); o++){
							obj = (Object) forceTemp.get(o);
							facade.writeDocument(obj, "force");
						}
					}
						
				}
			}	
			file = new File(path);
			facade.finishDocument(file);
		}
			
			
			
			
	}

}
