import Moteur.*;

public class Main {

    public static void main(String[] args) {
        Variable r = new RealVariable("r") ;
        Variable e = new IntegerVariable("e") ;
        Coefficients coefficients = new Coefficients() ;
        coefficients.put(r, new RationalNumber(7.));
        coefficients.put(e, new RationalNumber(2.));

        Constraint c1 = new Constraint(coefficients, new RationalNumber(6.)) ;
        Constraint c2 = new Constraint(coefficients,  new RationalNumber(10.)) ;
        Constraint c3 = new Constraint(coefficients,  new RationalNumber(15.)) ;
        Constraint c4 = new Constraint(coefficients,  new RationalNumber(17.)) ;

        System.out.println(c1);


        And and = new And(c1, c1) ;
        System.out.println(and);

        Not not = new Not(c1) ;
        System.out.println(not);

        Or or = new Or(and,c1) ;
        System.out.println(or);

        Formula phi = new Not(or) ;
        System.out.println(phi);



       // r = new RealVariable("x1") ;
       // e = new Entier("1") ;
        Interpretation interp = new Interpretation() ;
        interp.put(r, new RationalNumber(1.));
        interp.put(e, new RationalNumber(0.));
        System.out.println("c1 = "+c1 +"\n"+interp.satisfies(c1));

        and = new And(c1, c1) ;
        System.out.println("************************************");
        System.out.println(and);
        System.out.println(interp.satisfies(and));

        not = new Not(and) ;
        System.out.println("************************************");
        System.out.println(not);
        System.out.println(interp.satisfies(not));

        Not not1 = new Not(not) ;
        System.out.println("************************************");
        System.out.println(not1);
        System.out.println(interp.satisfies(not1));

        and = new And(c1, c2) ;
        System.out.println("************************************");
        System.out.println(and);
        System.out.println(interp.satisfies(and));

        System.out.println("DNF************************************");
        System.out.println(and);
        System.out.println(and.toNNF());
        System.out.println(and.toDNF());

        System.out.println("************************************");
        not = new Not(and) ;
        System.out.println(not);
        System.out.println(not.toNNF());
        phi = not.toNNF();
        System.out.println(phi.toDNF());

        System.out.println("************************************");
        or = new Or(c1, c2) ;
        System.out.println(or);
        System.out.println(or.toNNF());
        phi = or.toNNF();
        System.out.println(phi.toDNF());

        System.out.println("************************************");
        not = new Not(or) ;
        System.out.println(not);
        System.out.println(not.toNNF());
        phi = not.toNNF();
        System.out.println(phi.toDNF());


        System.out.println("************************************");
        or = new Or(c1, and) ;
        System.out.println(or);
        System.out.println(or.toNNF());
        phi = or.toNNF();
        System.out.println(phi.toDNF());

        System.out.println("************************************");
        not = new Not(or) ;
        System.out.println(not);
        System.out.println(not.toNNF());
        phi = not.toNNF();
        System.out.println(phi.toDNF());

        System.out.println("************************************");
        Or or1 = new Or(c2, c3) ;
        or = new Or(c1, c4) ;

        and = new And(or, or1) ;
        System.out.println(and);
        System.out.println(and.toNNF());
        phi = and.toNNF();
        System.out.println(phi.toDNF());

        System.out.println("************************************");
        and = new And(or1, c1) ;
        System.out.println(and);
        System.out.println(and.toNNF());
        phi = and.toNNF();
        System.out.println(phi.toDNF());

        System.out.println("************************************");
        Or or3 = new Or(or, or1) ;
        System.out.println(or3);
        System.out.println(or3.toNNF());
        phi = or3.toNNF();
        System.out.println(phi.toDNF());

        System.out.println("************************************");
        and = new And(new And(c1, c2), new And(c3, c4)) ;
        System.out.println(and);
        System.out.println(and.toNNF());
        phi = and.toNNF();
        System.out.println(phi.toDNF());

        System.out.println("************************************");
        or = new Or(c1, new And(c2, new Or(c3, c4))) ;
        System.out.println(or);
        System.out.println(or.toNNF());
        phi = or.toNNF();
        System.out.println(phi.toDNF());
        phi = phi.toDNF() ;
        System.out.println("phi = "+phi +"\n"+interp.satisfies(phi));
        coefficients.put(e, new RationalNumber(9.));

/*
        and = new And(not, c1) ;
        System.out.println(and);
        System.out.println(interp.satisfait(and));

   /*     or = new Or(not, c1);
        System.out.println(or);
        System.out.println(i.satisfait(or));

        and = new And(c1, c1) ;
        not = new Not(and) ;

        Formule phi2 = not.toNNF() ;
        System.out.println("**********************************************\n"+ not);
        System.out.println(phi2);

        phi2 = c1.toNNF() ;
        System.out.println("**********************************************\n"+c1);
        System.out.println(phi2);

        phi2 = and.toNNF() ;
        System.out.println("**********************************************\n"+ and);
        System.out.println(phi2);
        and = new And(c1, c2);
        or = new Or(and,c2) ;
        not = new Not(or) ;

        phi2 = not.toNNF() ;
        System.out.println("**********************************************\n"+ not);
        System.out.println(phi2);

        and = new And(c1, new Not(c2));
        phi2 = and.toNNF() ;
        System.out.println("**********************************************\n"+ and);
        System.out.println(phi2);

        not = new Not(c1) ;
        phi2 = not.toNNF() ;
        System.out.println("**********************************************\n"+ not);
        System.out.println(phi2);

        and = new And(c1, new Or(c1,c2));
        phi2 = and.toDNF() ;
        System.out.println("**********************************************\n"+ and);
        System.out.println(phi2);

        and = new And(c1, new And(c1,new Or(c1, c2)));
        phi2 = and.toDNF() ;
        System.out.println("**********************************************\n"+ and);
        System.out.println(phi2);*/
    }
}
