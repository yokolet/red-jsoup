# -*- ruby -*-

require 'rake/javaextensiontask'

jars = Dir.glob("lib/**/*.jar")
Rake::JavaExtensionTask.new('red-jsoup') do |ext|
  ext.classpath = jars.map {|x| File.expand_path x}.join ":"
  ext.source_version = '21'
  ext.target_version = '21'
end

task :default => [:compile]
