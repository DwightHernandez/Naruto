
package Ninja.model.classes.builder;

import Ninja.model.classes.Ninja;
public class NinjaConcreteBuilder implements NinjaBuilder {

    private Ninja ninja = new Ninja();

    @Override
    public NinjaBuilder ninjaID(long ninjaID) {
        ninja.setNinjaID(ninjaID);
        return this;
    }



    @Override
    public NinjaBuilder nombreNinja(String nombreNinja) {
        ninja.setNombreNinja(nombreNinja);
        return this;
    }

    @Override
    public NinjaBuilder rangoNinja(String rangoNinja) {
        ninja.setRangoNinja(rangoNinja);
        return this;
    }


    @Override
    public NinjaBuilder aldeaNinja(String aldeaNinja) {
        ninja.setAldeaNinja(aldeaNinja);
        return this;
    }


    @Override
    public Ninja build() {
        return ninja;
    }

}
