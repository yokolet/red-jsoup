package rjsoup;

import java.util.List;
import org.jruby.Ruby;
import org.jruby.RubyArray;
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

@JRubyClass(name="RedJsoup::Parser")
public class Parser extends RubyObject {
    private static final long serialVersionUID = 1L;

    public Parser(Ruby runtime, RubyClass klazz) {
        super(runtime, klazz);
    }
    
    @JRubyMethod(name = "parse")
    public IRubyObject parseHtml(ThreadContext context, IRubyObject input) {
        if (input instanceof RubyString) {
            String html = input.asJavaString();
            Node node = Jsoup.parse(html);
            RubyArray nodeList = RubyArray.newArray(context);
            nodeList = findNodeList(context, node, nodeList);
            return nodeList;
        } else {
            return context.getRuntime().getNil();
        }
    }
    
    @JRubyMethod
    public IRubyObject to_s(ThreadContext context) {
        return context.getRuntime().newString("<html></html>");
    }

    private RubyArray findNodeList(ThreadContext context, Node node, RubyArray nodeList) {
        List<Node> nodes = node.childNodes();
        for (Node n : nodes) {
            nodeList = findNodeList(context, n, nodeList);
        }
        nodeList.add(context.getRuntime().newString(node.nodeName()));
        return nodeList;
    }
}
