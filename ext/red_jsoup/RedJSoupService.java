package red_jsoup;

import java.io.IOException;

import org.jruby.Ruby;
import org.jruby.RubyClass;
import org.jruby.RubyModule;
import org.jruby.runtime.ObjectAllocator;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.runtime.load.BasicLibraryService;
import org.jruby.api.Define;

public class RedJSoupService implements BasicLibraryService {

    @Override
    public boolean basicLoad(Ruby runtime) throws IOException {
        RubyModule rjsModule = Define.defineModule(runtime.getCurrentContext(), "RedJSoup");
        RubyClass rjsClass = rjsModule.defineClassUnder(runtime.getCurrentContext(), "Parser", runtime.getObject(), PARSER_ALLOCATOR);
        rjsClass.defineMethods(runtime.getCurrentContext(), Parser.class);
        return true;
    }

    private static ObjectAllocator PARSER_ALLOCATOR = new ObjectAllocator() {
        public IRubyObject allocate(Ruby runtime, RubyClass klazz) {
            return new Parser(runtime, klazz);
        }
    };
}
