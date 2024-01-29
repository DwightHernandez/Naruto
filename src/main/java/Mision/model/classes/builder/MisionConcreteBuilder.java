
package Mision.model.classes.builder;

import Mision.model.classes.Mision;

public class MisionConcreteBuilder implements MisionBuilder {

        private Mision mision = new Mision();

        @Override
        public MisionBuilder misionID(long misionID) {
            mision.setMisionID(misionID);
            return this;
        }

    @Override
    public MisionBuilder descripcionMision(String descripcionMision) {
        mision.setDescripcionMision(descripcionMision);
        return this;
    }

    @Override
    public MisionBuilder rangoMision(String rangoMision) {
        mision.setRangoMision(rangoMision);
        return this;
    }

    @Override
    public MisionBuilder recompensaMision(double recompensaMision) {
        mision.setRecompenzaMision(recompensaMision);
        return this;
    }

    @Override
    public Mision build() {
        return mision;
    }


}

