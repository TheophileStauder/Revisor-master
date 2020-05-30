# RevisionCroyances


System of revision of beliefs in a propositional closure of linear constraints.

What's working :
-Negation Normal Form ;
-Disjonctive Normal Form ;
-Iterpreation.

-'printformula' command in console to display formula in PCLC 

The formulas  and interpretations are created in the class Moteur.
Those classes which represent PCLC formalism are integrate in the project as the pclc package.



#####To work on project ##############
Read the two ReadMe files in the read me directory.

It is explain how to install and work on the project on Eclipse IDE.
However we both worked on IntelliJ IDE , there is less maven plugin problems.
Here is the way to work on the project on intelliji IDE 

Install maven as explain in the README_PROJECT file , you will also need javacup and jflex libraries.

1.Download and unzip the Revisor-Master project from github
2.Open IntelliJ and select "Import Project"
3.Select extracted directory "Revisor-Master" from step 1.
4.Then select option "Import project from external model" and select MAVEN

Now you can work in the revisorEngine/revisorEngine-pcsfc directory, run pom.xml to build project.
Main class is RevisorPCSFCConsoleMode


