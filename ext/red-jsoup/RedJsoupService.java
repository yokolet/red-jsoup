package rjsoup;

import java.io.IOException;

import org.jruby.Ruby;
import org.jruby.RubyClass;
import org.jruby.RubyModule;
import org.jruby.runtime.ObjectAllocator;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.runtime.load.BasicLibraryService;
import org.jruby.api.Define;

public class RedJsoupService implements BasicLibraryService {

    @Override
    public boolean basicLoad(final Ruby runtime) throws IOException {
        RubyModule rjs = Define.defineModule(runtime.getCurrentContext(), "RedJsoup");
        RubyClass parser = rjs.defineClassUnder(runtime.getCurrentContext(), "Parser", runtime.getObject(), FRACTION_ALLOCATOR);
        parser.defineMethods(runtime.getCurrentContext(), Parser.class);
        return true;
    }
    
    private static ObjectAllocator FRACTION_ALLOCATOR = new ObjectAllocator() {
        public IRubyObject allocate(Ruby runtime, RubyClass klazz) {
            return new Parser(runtime, klazz);
        }
    };
}
