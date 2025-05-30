from _widgets import *
def Quiz1():   
    Q = create_multipleChoice_widget('Q1: In the System dynaimics, the terme dynamic refers to:',
                                        ['Just motion',
                                         'Change over time',
                                         'Freezing the time',
                                         'All of the above'],
                                      'Change over time')
    

    display(Q)
    

def Quiz2(): 
    Q = create_multipleChoice_widget('Q2: Whic one of following is not a modeling/simulation technique?',
                                        ['Multi-Agents',
                                         'Cellular Automata',
                                         'Differential Equations',
                                         'Complex Network',
                                         'Discrete Event',
                                         'None of the above'],
                                      'None of the above')
    
    display(Q)

def Quiz3(): 
    Q = create_multipleChoice_widget('Q3: Given to you a system where we want to model the poupation growth in Algeria country over the last 50 years. Which modeling technique can be appropriat to model/simulate such a system?',
                                        ['Multi-Agents',
                                         'Cellular Automata',
                                         'Differential Equations',
                                         'Complex Network',
                                         'Discrete Event',
                                         'None of the above'],
                                      'Differential Equations')
    
    display(Q)  

def Quiz4(): 
    Q = create_multipleChoice_widget('Q4: The type of systems which are characterized by state variables quantized at certain levels are called as',
                                        ['analog',
                                         'discrete',
                                         'continuous',
                                         'digital'],
                                      'discrete')
    
    display(Q) 

def Quiz5(): 
    Q = create_multipleChoice_widget('Q5: The type of systems which are characterized by state variables capable of taking any value in a particular interval of values are called as',
                                        ['analog',
                                         'discrete',
                                         'continuous',
                                         'digital'],
                                      'continuous')
    
    display(Q) 

def Quiz6(): 
    Q = create_multipleChoice_widget('Q6: A chemical reaction system whose model is analyzed throught a set of Partial Differential Equations is simulated using',
                                        ['A Static simulation model',
                                         'A Deterministic simulation model',
                                         'A Stochastic simulation model',
                                         'A Continuous simulation model',
                                         'A Discrete simulation model'],
                                      'A Deterministic simulation model')
    
    display(Q) 

def Quiz7(): 
    Q = create_multipleChoice_widget('Q7: A Bank Queue System that is modeled using a discret event modeling techniques is simulated as',
                                        ['(a) A Static simulation model',
                                         '(b) A Deterministic simulation model',
                                         '(c) A Stochastic simulation model',
                                         '(d) A Continuous simulation model',
                                         '(e) A Discrete simulation model',
                                         '(b) and (e)',
                                         '(c) and (e)'],
                                      '(c) and (e)')
    
    display(Q) 

def Quiz8(): 
    Q = create_multipleChoice_widget('Q8: Which simulation modeling technique is well suited to simulate crowd entry and exit from  the different gates of a new built football staduim?',
                                        ['Multi-Agents',
                                         'Cellular Automata',
                                         'Differential Equations',
                                         'Complex Network',
                                         'Discrete Event',
                                         'None of the above'],
                                      'Multi-Agents')
    
    display(Q) 

def Quiz9(): 
    Q = create_multipleChoice_widget('Q9: Which simulation modeling technique is well suited to simulate patterns in animal skins?',
                                        ['Multi-Agents',
                                         'Cellular Automata',
                                         'Differential Equations',
                                         'Complex Network',
                                         'Discrete Event',
                                         'None of the above'],
                                      'Cellular Automata')
    
    display(Q) 

def Quiz10(): 
    Q = create_multipleChoice_widget('Q10: Which simulation modeling technique is well suited to investigate the aerodynamics of the Ferrari’s new Formula 1 car?',
                                        ['Multi-Agents',
                                         'Cellular Automata',
                                         'Differential Equations',
                                         'Complex Network',
                                         'Discrete Event',
                                         'None of the above'],
                                      'Differential Equations')
    
    display(Q) 

def Quiz11(): 
    Q = create_multipleChoice_widget('Q11: Which simulation modeling technique is well suited to analyse social interactions networks in twiter platform?',
                                        ['Multi-Agents',
                                         'Cellular Automata',
                                         'Differential Equations',
                                         'Complex Network',
                                         'Discrete Event',
                                         'None of the above'],
                                      'Complex Network')
    
    display(Q) 



Quiz1()
Quiz2()
Quiz3()
Quiz4()
Quiz5()
Quiz6()
Quiz7()
Quiz8()
Quiz9()
Quiz10()
Quiz11()