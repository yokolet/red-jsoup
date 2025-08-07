package red_jsoup;

import org.jruby.Ruby;
import org.jruby.RubyClass;
import org.jruby.RubyObject;
import org.jruby.RubyString;
import org.jruby.anno.JRubyClass;
import org.jruby.anno.JRubyMethod;
import org.jruby.runtime.Arity;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Node;

@JRubyClass(name="Parser")
public class Parser extends RubyObject {
    private static final long serialVersionUID = 1L;

    @JRubyMethod(name="new", meta = true, rest = true)
    public static IRubyObject rbNew(ThreadContext context, IRubyObject klazz, IRubyObject[] args) {
        Parser parser = (Parser) ((RubyClass)klazz).allocate(context);
        return parser;
    }

    public Parser(Ruby runtime, RubyClass klazz) {
        super(runtime, klazz);
    }

    @JRubyMethod
    public IRubyObject parse(ThreadContext context, IRubyObject input) {
        if (input instanceof RubyString) {
            String html = input.asJavaString();
            Node node = Jsoup.parse(html);
            return RubyString.newString(context.getRuntime(), node.nodeName());
        } else {
            return context.getRuntime().getNil();
        }
    }

    @JRubyMethod
    public IRubyObject to_s(ThreadContext context) {
        return context.getRuntime().newString("<html></html>");
    }

}
