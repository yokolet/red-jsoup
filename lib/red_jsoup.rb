require 'jruby'
require_relative 'red-jsoup.jar'

require 'commons-math-2.2'

Java::Rjsoup::FractionService.new.basicLoad(JRuby.runtime)
