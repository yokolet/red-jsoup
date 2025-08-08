require 'jruby'
require_relative 'red-jsoup.jar'

require 'jsoup-1.21.1'

Java::Rjsoup::RedJsoupService.new.basicLoad(JRuby.runtime)
