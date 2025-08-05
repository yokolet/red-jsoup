package red_jsoup;

import org.jruby.Ruby;
import org.jruby.RubyClass;
import org.jruby.RubyObject;
import org.jruby.anno.JRubyClass;
import org.jruby.anno.JRubyMethod;
import org.jruby.runtime.Arity;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;

@JRubyClass(name="RedJSoupParser")
public class Parser extends RubyObject {
    private static final long serialVersionUID = 1L;

    @JRubyMethod(name="new", meta = true, rest = true)
    public static IRubyObject rbNew(ThreadContext context, IRubyObject klazz, IRubyObject[] args) {
        Parser parser = (Parser) ((RubyClass)klazz).allocate(context);
        parser.init(context, args);
        return parser;
    }

    public Parser(Ruby runtime, RubyClass klass) {
        super(runtime, klass);
    }

    void init(ThreadContext context, IRubyObject[] args) {
        Arity.checkArgumentCount(context, args, 2, 2);
    }

    @JRubyMethod(name = "parse")
    public IRubyObject parse(ThreadContext context, IRubyObject other) {
        if (other instanceof Parser) {
            // To Be Implemented
            return this;
        } else {
            throw context.getRuntime().newArgumentError("check arguments");
        }
    }

    @JRubyMethod
    public IRubyObject to_s(ThreadContext context) {
        return context.getRuntime().newString("<html></html>");
    }

}
