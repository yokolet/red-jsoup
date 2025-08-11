require 'java'
require 'pathname'

$: << Pathname.new(__dir__).join("..", "lib")
require 'red_jsoup'

p = RedJsoup::Parser.new
html = "<html><head><title>First parse</title></head><body><p>Parsed HTML into a doc.</p></body></html>";

ret = p.parse(html)
puts(ret)
