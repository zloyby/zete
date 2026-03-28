package by.zloy.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class LambdaVisitorUtil<A> implements Function<Object, A> {
    private final Map<Class<?>, Function<Object, A>> functions = new HashMap<>();

    public <B> Acceptor<A, B> on(Class<B> clazz) {
        return new Acceptor<>(this, clazz);
    }

    @Override
    public A apply(Object o) {
        return functions.get(o.getClass()).apply(o);
    }

    public static class Acceptor<A, B> {
        private final LambdaVisitorUtil visitor;
        private final Class<B> clazz;

        public Acceptor(LambdaVisitorUtil<A> visitor, Class<B> clazz) {
            this.visitor = visitor;
            this.clazz = clazz;
        }

        @SuppressWarnings("unchecked")
        public LambdaVisitorUtil<A> then(Function<B, A> f) {
            visitor.functions.put(clazz, f);
            return visitor;
        }
    }
}
