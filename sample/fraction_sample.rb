require 'java'
require 'pathname'

$: << Pathname.new(__dir__).join("..", "lib")
require 'red_jsoup'

f = RedJsoup::Fraction.new(1, 1)
(2..4).each do |i|
  f.add!(RedJsoup::Fraction.new(1, i))
end
puts f
