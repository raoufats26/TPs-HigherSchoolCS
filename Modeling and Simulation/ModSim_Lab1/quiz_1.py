from _widgets import *
def Quiz1():   
    Q = create_multipleChoice_widget('Q1: Which comes first, the model or the simulation?',
                                        ['The two are unrelated and can be created in any order',
                                         'They are created at the same time because they are pretty much the same thing',
                                         'The model is created first because a simulation needs models to run'],
                                      'The model is created first because a simulation needs models to run')
    

    display(Q)
    

def Quiz2(): 
    Q = create_multipleChoice_widget('Q2: Models can be helpful in scientific investigations because',
                                        ['it may not be possible to work with the real thing',
                                         'they can be smaller and more manageable than the real thing',
                                         'they can be safer to work with than the real thing',
                                         'all of the above'],
                                      'all of the above')
    
    display(Q)

def Quiz3(): 
    Q = create_multipleChoice_widget('Q3: Which of the following is a limitation of using a model to study something?',
                                        ['A model cannot represent a thing exactly',
                                         'A model cannot help study things that are dangerous',
                                         'A model cannot reproduce things that are too far away',
                                         'A model cannot show things that are too small or too large'],
                                      'A model cannot represent a thing exactly')
    
    display(Q)  

def Quiz4(): 
    Q = create_multipleChoice_widget('Q4: Scientists use ___________ to understand how systems work',
                                        ['models',
                                         'figures',
                                         'process',
                                         'energy'],
                                      'models')
    
    display(Q) 

def Quiz5(): 
    Q = create_multipleChoice_widget('Q5: The Temporal dimension in a model can be:',
                                        ['Continuous',
                                         'Discrete',
                                         'Discrete Event',
                                         'One of the above'
                                         ],
                                      'One of the above')
    
    display(Q) 



Quiz1()
Quiz2()
Quiz3()
Quiz4()
Quiz5()