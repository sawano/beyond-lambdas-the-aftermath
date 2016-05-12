package beyondlambdas.slides.s1;

import static beyondlambdas.slides.s1.Advise.currentAdvise;

@SuppressWarnings("ConstantConditions")
public class _1a {

    final Oracle oracle = new Oracle();

    String _() {
        final Advise advise = currentAdvise();

        if (advise != null) {
            return advise.cheap();
        }
        else {
            return oracle.advise().expensive();
        }
    }
}
