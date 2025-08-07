# frozen_string_literal: true
require 'jruby'
require_relative 'red_jsoup.jar'

module RedJSoup
  module Parser
    red_jsoup.RedJSoupService.new.basicLoad(JRuby.runtime)
  end
end
