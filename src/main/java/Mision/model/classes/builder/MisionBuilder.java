package Mision.model.classes.builder;

import Mision.model.classes.Mision;


public interface MisionBuilder {


    MisionBuilder misionID(long misionID);

    MisionBuilder descripcionMision(String descripcionMision);


    MisionBuilder rangoMision(String rangoMision);


    MisionBuilder recompensaMision(double recompensaMision);



    Mision build();
}
