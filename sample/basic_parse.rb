# frozen_string_literal: true

require 'java'
require 'pathname'

$: << Pathname.new(__dir__).join("..", "lib")
require 'red_jsoup'

p = RedJSoup::Parser.new
html = "<html><head><title>First parse</title></head><body><p>Parsed HTML into a doc.</p></body></html>";

puts(p.inspect)
puts("string representation: #{p.to_s}")
ret = p.parse(html)
puts ret
